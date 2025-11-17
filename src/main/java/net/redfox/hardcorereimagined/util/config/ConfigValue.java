package net.redfox.hardcorereimagined.util.config;

import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public interface ConfigValue<E> {
  Map<Class<?>, IForgeRegistry<?>> FORGE_REGISTRY_MAP =
      Map.of(
          Item.class,
          ForgeRegistries.ITEMS,
          Block.class,
          ForgeRegistries.BLOCKS,
          Biome.class,
          ForgeRegistries.BIOMES);
  Map<Class<?>, ResourceKey<? extends Registry<?>>> REGISTRY_MAP =
      Map.of(
          Item.class,
          Registries.ITEM,
          Block.class,
          Registries.BLOCK,
          Biome.class,
          Registries.BIOME);
  Map<Class<?>, ?> NULL_VALUES = Map.of(Item.class, Items.AIR, Block.class, Blocks.AIR);

  boolean is(E value);

  boolean isInvalid(Class<E> clazz);

  default E getValue(Class<?> clazz, String value) {
    if (!clazz.equals(Biome.class))
      return (E) FORGE_REGISTRY_MAP.get(clazz).getValue(ResourceLocation.parse(value));
    else
      return ((Registry<E>)
              Minecraft.getInstance()
                  .level
                  .registryAccess()
                  .registry(REGISTRY_MAP.get(clazz))
                  .get())
          .get(ResourceLocation.parse(value));
  }
}
