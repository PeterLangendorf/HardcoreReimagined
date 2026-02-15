package net.redfox.survivaloverhaul.util.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class StringParsingUtil {
  public static <T, R> void fillMap(Map<T, R> map, List<? extends String> toFill, Function<String, T> key, Function<String, R> value) {
    for (String base : toFill) {
      String[] split = base.trim().split(":");
      map.put(key.apply(split[0]), value.apply(split[1]));
    }
  }
}