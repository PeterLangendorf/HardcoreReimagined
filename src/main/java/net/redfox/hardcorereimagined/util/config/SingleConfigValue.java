package net.redfox.hardcorereimagined.util.config;

import java.util.ArrayList;
import java.util.List;
import net.redfox.hardcorereimagined.util.StringParser;

public class SingleConfigValue<E> implements ConfigValue<E> {
  private final List<E> values;

  public SingleConfigValue(String value, Class<E> clazz) {
    this.values = new ArrayList<>();
    values.set(0, StringParser.parse(clazz, value));
  }

  @Override
  public boolean is(E value) {
    return values.contains(value);
  }
}
