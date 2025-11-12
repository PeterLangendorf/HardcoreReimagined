package net.redfox.hardcorereimagined.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.redfox.hardcorereimagined.util.config.ConfigValue;
import net.redfox.hardcorereimagined.util.config.ListConfigValue;
import net.redfox.hardcorereimagined.util.config.SingleConfigValue;
import oshi.util.tuples.Pair;

public class FormattedConfigValues {
  public static class Temperature {
    public static final Map<ConfigValue<Biome>, Integer> BIOME_TEMPERATURES = new HashMap<>();
    public static final Map<ConfigValue<Block>, Integer> BLOCK_TEMPERATURES = new HashMap<>();
    public static final Map<ConfigValue<Block>, Integer> FLUID_TEMPERATURES = new HashMap<>();
    public static final Map<ConfigValue<Block>, Integer> BLOCK_TOP_TEMPERATURES = new HashMap<>();
    public static final Map<ConfigValue<Item>, Pair<Integer, Integer>> ARMOR_INSULATIONS =
        new HashMap<>();
    public static final BooleanSupplier FLUCTUATE_TEMPERATURE =
        ModCommonConfigs.TEMPERATURE_FLUCTUATION::get;
  }

  public static void populateConfigValues() {
    createSingleIntegerConfigValues(
        ModCommonConfigs.BIOME_TEMPERATURE.get(), Temperature.BIOME_TEMPERATURES, Biome.class);
    createSingleIntegerConfigValues(
        ModCommonConfigs.INSULATORS.get(), Temperature.BLOCK_TEMPERATURES, Block.class);
    createSingleIntegerConfigValues(
        ModCommonConfigs.FLUID_TEMPERATURES.get(), Temperature.FLUID_TEMPERATURES, Block.class);
    createSingleIntegerConfigValues(
        ModCommonConfigs.WALKING_ON_TOP_BOOTS.get(),
        Temperature.BLOCK_TOP_TEMPERATURES,
        Block.class);
    createPairIntegerConfigValues(
        ModCommonConfigs.ARMOR.get(), Temperature.ARMOR_INSULATIONS, Item.class);
  }

  private static <E> void createSingleIntegerConfigValues(
      List<String> forgeConfigValue, Map<ConfigValue<E>, Integer> storage, Class<E> clazz) {
    for (String entry : forgeConfigValue) {
      if (entry.startsWith("[")) {
        storage.put(
            new ListConfigValue<>(getStringArray(entry), clazz),
            Integer.parseInt(entry.substring(entry.indexOf("]") + 2)));
      } else {
        storage.put(
            new SingleConfigValue<>(getString(entry), clazz),
            Integer.parseInt(entry.substring(entry.indexOf(",") + 1)));
      }
    }
  }

  private static <E> void createPairIntegerConfigValues(
      List<String> forgeConfigValue,
      Map<ConfigValue<E>, Pair<Integer, Integer>> storage,
      Class<E> clazz) {
    for (String entry : forgeConfigValue) {
      if (entry.startsWith("[")) {
        String[] ints = entry.substring(entry.indexOf("]") + 2).split(",");
        storage.put(
            new ListConfigValue<>(getStringArray(entry), clazz),
            new Pair<>(Integer.parseInt(ints[0]), Integer.parseInt(ints[1])));
      } else {
        String[] ints = entry.substring(entry.indexOf(",") + 1).split(",");
        storage.put(
            new SingleConfigValue<>(getString(entry), clazz),
            new Pair<>(Integer.parseInt(ints[0]), Integer.parseInt(ints[1])));
      }
    }
  }

  public static <E> int checkMapForValue(Map<ConfigValue<E>, Integer> storage, E key) {
    for (ConfigValue<E> configValue : storage.keySet()) {
      if (configValue.is(key)) return storage.get(configValue);
    }
    return 0;
  }

  public static <E> Pair<Integer, Integer> checkMapForPair(
      Map<ConfigValue<E>, Pair<Integer, Integer>> storage, E key) {
    for (ConfigValue<E> configValue : storage.keySet()) {
      if (configValue.is(key)) return storage.get(configValue);
    }
    return new Pair<>(0, 0);
  }

  private static String[] getStringArray(String string) {
    return string.substring(1, string.indexOf("]")).split(",");
  }

  private static String getString(String string) {
    return string.substring(0, string.indexOf(","));
  }
}
