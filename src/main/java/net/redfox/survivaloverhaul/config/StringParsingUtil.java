package net.redfox.survivaloverhaul.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class StringParsingUtil {
  public static <T, R> void fillMap(Map<T, R> map, List<? extends String> toFill, Function<String, T> key,
      Function<String, R> value) {
    for (String base : toFill) {
      String[] split = base.trim().split(":");
      map.put(key.apply(split[0]), value.apply(split[1]));
    }
  }

  public static boolean matchesStringOrTag(String matchString, Item item) {
    if (matchString == null || matchString.isEmpty() || item == null) {
      return false;
    }

    if (matchString.startsWith("#")) {
      return ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(ResourceLocation.parse(matchString.substring(1))))
          .contains(item);
    } else {
      return ResourceLocation.parse(matchString).equals(ForgeRegistries.ITEMS.getKey(item));
    }
  }
}
