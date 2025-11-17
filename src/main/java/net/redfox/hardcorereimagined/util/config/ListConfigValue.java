package net.redfox.hardcorereimagined.util.config;

import java.util.ArrayList;
import java.util.List;

public class ListConfigValue<E> implements ConfigValue<E> {
  private final List<E> values;

  public ListConfigValue(String[] values, Class<E> clazz) {
    this.values = new ArrayList<>();
    for (String value : values) {
      this.values.add(getValue(clazz, value));
    }
  }

  @Override
  public boolean is(E value) {
    return values.contains(value);
  }

  @Override
  public boolean isInvalid(Class<E> clazz) {
    for (E value : values) {
      if (value == null || value.equals(ConfigValue.NULL_VALUES.get(clazz))) {
        return true;
      }
    }
    return false;
  }
}
