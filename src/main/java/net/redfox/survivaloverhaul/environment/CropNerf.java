package net.redfox.survivaloverhaul.environment;

import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.redfox.survivaloverhaul.util.config.JsonConfigReader;
import oshi.util.tuples.Pair;

public class CropNerf {
  private static final JsonArray JSON_CROP_VALUES =
      JsonConfigReader.getOrCreateJsonFile("environment/crop_nerf", JsonConfigReader.CROP_NERF)
          .get("values")
          .getAsJsonArray();
  private static final Map<Block, Pair<Double, List<Pair<Biome, Double>>>> CACHED_CROP_NERF_VALUES =
      new HashMap<>();

  public static void onCropGrowth(BlockEvent.CropGrowEvent event) {
    BlockState state = event.getState();
    Holder<Biome> biome = event.getLevel().getBiome(event.getPos());
    if (!CACHED_CROP_NERF_VALUES.containsKey(state.getBlock())) {
      JSON_CROP_VALUES.asList().stream()
          .filter(
              value ->
                  value
                      .getAsJsonObject()
                      .get("crop")
                      .getAsString()
                      .equals(state.getBlockHolder().unwrapKey().get().location().toString()))
          .findFirst()
          .ifPresentOrElse(
              value -> {
                CACHED_CROP_NERF_VALUES.put(
                    state.getBlock(),
                    new Pair<>(
                        value.getAsJsonObject().get("default_multiplier").getAsDouble(),
                        new ArrayList<>()));
              },
              () -> {
                CACHED_CROP_NERF_VALUES.put(state.getBlock(), null);
              });
    }

    var result = CACHED_CROP_NERF_VALUES.get(state.getBlock());
    if (result == null) return;

    Integer successChance = null;
    for (var value : result.getB()) {
      if (value.getA().equals(biome.get())) {
        successChance = (int) (1 / value.getB());
      }
    }
    if (successChance == null) {
      double defaultMultiplier =
          JSON_CROP_VALUES.asList().stream()
              .filter(
                  value ->
                      value
                          .getAsJsonObject()
                          .get("crop")
                          .getAsString()
                          .equals(state.getBlockHolder().unwrapKey().get().location().toString()))
              .findFirst()
              .get()
              .getAsJsonObject()
              .get("default_multiplier")
              .getAsDouble();

      JSON_CROP_VALUES.asList().stream()
          .filter(
              value ->
                  value
                      .getAsJsonObject()
                      .get("crop")
                      .getAsString()
                      .equals(state.getBlockHolder().unwrapKey().get().location().toString()))
          .findFirst()
          .get()
          .getAsJsonObject()
          .get("biome_overrides")
          .getAsJsonArray()
          .asList()
          .stream()
          .filter(
              value ->
                  value
                      .getAsJsonObject()
                      .get("biome")
                      .getAsString()
                      .equals(biome.unwrapKey().get().location().toString()))
          .findFirst()
          .ifPresentOrElse(
              value -> {
                CACHED_CROP_NERF_VALUES
                    .get(state.getBlock())
                    .getB()
                    .add(
                        new Pair<>(
                            biome.get(), value.getAsJsonObject().get("multiplier").getAsDouble()));
                event.setResult(Event.Result.DENY);
              },
              () -> {
                CACHED_CROP_NERF_VALUES
                    .get(state.getBlock())
                    .getB()
                    .add(new Pair<>(biome.get(), defaultMultiplier));
                event.setResult(Event.Result.DENY);
              });
      successChance = 1;
    }

    if (!(event.getLevel().getRandom().nextIntBetweenInclusive(1, successChance) == 1)) {
      event.setResult(Event.Result.DENY);
    }
  }
}
