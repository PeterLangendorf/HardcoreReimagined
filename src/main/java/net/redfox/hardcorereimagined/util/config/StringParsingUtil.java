package net.redfox.hardcorereimagined.util.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class StringParsingUtil {
  public static <T, R> void fillMap(Map<T, R> map, List<String> toFill, Function<String, T> key, Function<String, R> value) {
    for (String base : toFill) {
      System.out.println("blegg " + base + " .");
      String[] split = base.trim().split(":");
      T newKey = key.apply(split[0]);
      R newValue = value.apply(split[1]);
      System.out.println("blegg2 " + newKey + " , " + newValue);
      map.put(newKey,  newValue);
    }
  }
}