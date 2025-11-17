package net.redfox.hardcorereimagined.util.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.tags.ITag;

public class TagConfigValue<E> implements ConfigValue<E> {
  private final ITag<E> value;

  public TagConfigValue(String value, Class<E> clazz) {
    IForgeRegistry<E> registry = (IForgeRegistry<E>) ConfigValue.FORGE_REGISTRY_MAP.get(clazz);
    this.value =
        registry
            .tags()
            .getTag(TagKey.create(registry.getRegistryKey(), ResourceLocation.parse(value)));
  }

  @Override
  public boolean is(E value) {
    return this.value.contains(value);
  }

  @Override
  public boolean isInvalid(Class<E> clazz) {
    return !this.value.isEmpty();
  }
}
