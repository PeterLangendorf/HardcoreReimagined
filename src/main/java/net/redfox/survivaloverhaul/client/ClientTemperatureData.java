package net.redfox.survivaloverhaul.client;

import net.redfox.survivaloverhaul.util.MathHelper;

public class ClientTemperatureData {
  private static double playerTemperature;

  public static void set(double playerTemperature) {
    ClientTemperatureData.playerTemperature = MathHelper.roundToOneDecimal(playerTemperature);
  }

  public static double getPlayerTemperature() {
    return MathHelper.roundToOneDecimal(playerTemperature);
  }
}
