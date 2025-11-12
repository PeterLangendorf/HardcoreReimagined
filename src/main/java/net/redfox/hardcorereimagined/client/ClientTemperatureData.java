package net.redfox.hardcorereimagined.client;

import net.redfox.hardcorereimagined.util.MathHelper;

public class ClientTemperatureData {
  private static double playerTemperature;

  public static void set(double playerTemperature) {
    ClientTemperatureData.playerTemperature = MathHelper.roundToOneDecimal(playerTemperature);
  }

  public static double getPlayerTemperature() {
    return MathHelper.roundToOneDecimal(playerTemperature);
  }
}
