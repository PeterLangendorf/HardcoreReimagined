package net.redfox.survivaloverhaul.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;
import net.redfox.survivaloverhaul.config.JsonConfigReader;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SymptomNerf {
  private static final JsonArray JSON_SYMPTOMS = JsonConfigReader
      .getOrCreateJsonFile("player/symptoms", JsonConfigReader.SYMPTOMS).get("values").getAsJsonArray();

  private static final TreeMap<Double, List<Pair<MobEffect, Integer>>> HUNGER_SYMPTOM_MAP = new TreeMap<>();
  private static final TreeMap<Double, List<Pair<MobEffect, Integer>>> HEALTH_SYMPTOM_MAP = new TreeMap<>();

  public static void init() {
    for (JsonElement element : JSON_SYMPTOMS) {
      JsonObject object = element.getAsJsonObject();
      List<Pair<MobEffect, Integer>> list = new ArrayList<>();
      for (JsonElement innerElement : object.getAsJsonArray("effects")) {
        list.add(new Pair<>(
            ForgeRegistries.MOB_EFFECTS
                .getValue(ResourceLocation.parse(innerElement.getAsJsonObject().get("effect").getAsString())),
            innerElement.getAsJsonObject().get("amplifier").getAsInt()));
      }

      if (object.get("condition_type").getAsString().equals("hunger")) {
        HUNGER_SYMPTOM_MAP.put(object.get("value").getAsDouble(), list);
      } else if (object.get("condition_type").getAsString().equals("health")) {
        HEALTH_SYMPTOM_MAP.put(object.get("value").getAsDouble(), list);
      }
    }
  }

  public static void periodicUpdate(ServerPlayer player) {
    if (player.isCreative() || player.isDeadOrDying())
      return;

    double hunger = player.getFoodData().getFoodLevel();
    for (double key : HUNGER_SYMPTOM_MAP.keySet()) {
      if (hunger <= key) {
        for (var effect : HUNGER_SYMPTOM_MAP.get(key)) {
          player.addEffect(create(effect.getA(), effect.getB()));
        }
        break;
      }
    }

    double health = player.getHealth();
    for (double key : HEALTH_SYMPTOM_MAP.keySet()) {
      if (health <= key) {
        for (var effect : HEALTH_SYMPTOM_MAP.get(key)) {
          player.addEffect(create(effect.getA(), effect.getB()));
        }
        break;
      }
    }
  }

  public static MobEffectInstance create(MobEffect effect, int amplifier) {
    return create(effect, 40, amplifier);
  }

  public static MobEffectInstance create(MobEffect effect, int durationInTicks, int amplifier) {
    return new MobEffectInstance(effect, durationInTicks, amplifier, false, false, true);
  }
}
