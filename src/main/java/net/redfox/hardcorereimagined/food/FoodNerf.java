package net.redfox.hardcorereimagined.food;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.redfox.hardcorereimagined.HardcoreReimagined;

public class FoodNerf {
  public static final Map<Item, String> TOOLTIPS = new HashMap<>();

  public static void nerfFoods() {
    HashMap<String, Integer> loaded = new HashMap<>();
    HashMap<String, Integer> skipped = new HashMap<>();
    for (FoodStats stats : PublishedConfigValues.FOOD_VALUES) {
      if (ModList.get().isLoaded(stats.namespace())) {
        if (!loaded.containsKey(stats.namespace())) {
          loaded.put(stats.namespace(), 1);
        } else {
          loaded.put(stats.namespace(), loaded.get(stats.namespace()) + 1);
        }
        Item value = ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(stats.getName()));
        if (value != null && value != Items.AIR) {
          if (value.isEdible()) {
            TOOLTIPS.put(value, stats.presetFoot());
            modifyFoodProps(
                value,
                new FoodProperties.Builder()
                    .nutrition(stats.hunger())
                    .saturationMod(stats.saturation() / 2)
                    .build());
            if (stats.maxStackSize() != -1) {
              modifyMaxStackSize(value, stats.maxStackSize());
            }
          } else {
            HardcoreReimagined.LOGGER.error(
                "{} is not an edible item and was therefore skipped", stats.getName());
            if (!skipped.containsKey(stats.namespace())) {
              skipped.put(stats.namespace(), 1);
            } else {
              skipped.put(stats.namespace(), skipped.get(stats.namespace()) + 1);
            }
          }
        } else {
          HardcoreReimagined.LOGGER.error(
              "{} does not exist and was therefore skipped", stats.getName());
          if (!skipped.containsKey(stats.namespace())) {
            skipped.put(stats.namespace(), 1);
          } else {
            skipped.put(stats.namespace(), skipped.get(stats.namespace()) + 1);
          }
        }
      } else {
        if (!skipped.containsKey(stats.namespace())) {
          skipped.put(stats.namespace(), 1);
        } else {
          skipped.put(stats.namespace(), skipped.get(stats.namespace()) + 1);
        }
      }
    }

    for (String namespace : loaded.keySet()) {
      HardcoreReimagined.LOGGER.info(
          "{} items from {} were loaded!", loaded.get(namespace), namespace);
    }
    for (String namespace : skipped.keySet()) {
      HardcoreReimagined.LOGGER.info(
          "{} items from {} were skipped!", skipped.get(namespace), namespace);
    }
  }

  private static void modifyFoodProps(Item item, FoodProperties props) {
    try {
      Field foodfield = ObfuscationReflectionHelper.findField(Item.class, "f_41380_");
      foodfield.setAccessible(true);
      foodfield.set(item, props);
    } catch (Exception e) {
      e.printStackTrace();
      HardcoreReimagined.LOGGER.error(e.getMessage());
    }
  }

  private static void modifyMaxStackSize(Item item, int maxStackSize) {
    try {
      Field maxStackSizeField = ObfuscationReflectionHelper.findField(Item.class, "f_41370_");
      maxStackSizeField.setAccessible(true);
      maxStackSizeField.set(item, maxStackSize);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
