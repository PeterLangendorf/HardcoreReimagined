package net.redfox.hardcorereimagined.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class StringParser {
  public static <E> E parse(Class<E> clazz, String value) {
    if (clazz.equals(Block.class)) {
      return (E) ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(value));
    } else if (clazz.equals(Biome.class)) {
      return (E) ForgeRegistries.BIOMES.getValue(ResourceLocation.parse(value));
    }
    return null;
  }
}
