package net.redfox.hardcorereimagined.util.config;

public class SingleConfigValue<E> implements ConfigValue<E> {
  private final E value;

  public SingleConfigValue(String value, Class<E> clazz) {
    this.value = getValue(clazz, value);
  }

  @Override
  public boolean is(E value) {
    return this.value.equals(value);
  }

  @Override
  public boolean isInvalid(Class<E> clazz) {
    return this.value == null || this.value.equals(ConfigValue.NULL_VALUES.get(clazz));
  }
}
