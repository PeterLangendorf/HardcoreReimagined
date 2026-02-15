package net.redfox.survivaloverhaul.util;

public class MathHelper {
  public static double roundToOneDecimal(double number) {
    return Math.round(number * 10.0) / 10.0;
  }

  public static float roundToOneDecimal(float number) {
    return Math.round(number * 10.0F) / 10.0F;
  }
}
