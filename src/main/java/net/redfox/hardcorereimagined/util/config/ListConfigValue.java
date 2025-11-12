package net.redfox.hardcorereimagined.util.config;

import java.util.ArrayList;
import java.util.List;
import net.redfox.hardcorereimagined.util.StringParser;

public class ListConfigValue<E> implements ConfigValue<E> {
  private final List<E> values;

  public ListConfigValue(String[] values, Class<E> clazz) {
    this.values = new ArrayList<>();
    for (String value : values) {
      this.values.add(StringParser.parse(clazz, value));
    }
  }

  @Override
  public boolean is(E value) {
    return values.contains(value);
  }
}
