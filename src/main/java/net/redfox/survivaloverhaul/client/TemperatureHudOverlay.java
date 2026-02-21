package net.redfox.survivaloverhaul.client;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.redfox.survivaloverhaul.SurvivalOverhaul;
import net.redfox.survivaloverhaul.config.ModClientConfigs;

public class TemperatureHudOverlay {
  public static boolean gaugeEnabled = true;
  public static boolean readingEnabled = true;

  private static final ResourceLocation TEMPERATURE_0 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/0.png");
  private static final ResourceLocation TEMPERATURE_1 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/1.png");
  private static final ResourceLocation TEMPERATURE_2 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/2.png");
  private static final ResourceLocation TEMPERATURE_3 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/3.png");
  private static final ResourceLocation TEMPERATURE_4 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/4.png");
  private static final ResourceLocation TEMPERATURE_5 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/5.png");
  private static final ResourceLocation TEMPERATURE_6 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/6.png");
  private static final ResourceLocation TEMPERATURE_7 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/7.png");
  private static final ResourceLocation TEMPERATURE_8 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/8.png");
  private static final ResourceLocation TEMPERATURE_9 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/9.png");
  private static final ResourceLocation TEMPERATURE_10 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/10.png");
  private static final ResourceLocation TEMPERATURE_11 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/11.png");
  private static final ResourceLocation TEMPERATURE_12 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/12.png");
  private static final ResourceLocation TEMPERATURE_13 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/13.png");
  private static final ResourceLocation TEMPERATURE_14 = ResourceLocation.fromNamespaceAndPath(SurvivalOverhaul.MOD_ID,
      "textures/gui/temperature_gauge/14.png");

  public static void init() {
    final String displayMode = ModClientConfigs.TEMP_DISPLAY_MODE.get();
    switch (displayMode) {
      case "GAUGE" -> readingEnabled = false;
      case "NUMBER" -> gaugeEnabled = false;
      case "NONE" -> {
        gaugeEnabled = false;
        readingEnabled = false;
      }
    }
  }

  public static final IGuiOverlay TEMPERATURE_GAUGE = ((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
    if (!gaugeEnabled)
      return;

    final int OVERLAY_WIDTH = (int) (1920.0f / 120.0f);
    final int OVERLAY_HEIGHT = (int) (1080.0f / 67.5f);

    int OVERLAY_X = (screenWidth / 2) - (OVERLAY_WIDTH / 2);
    int OVERLAY_Y = screenHeight - 54;

    if (ClientTemperatureData.getPlayerTemperature() >= 80 || ClientTemperatureData.getPlayerTemperature() <= -80) {
      switch ((int) (Math.random() * 4) + 1) {
        case 1 :
          OVERLAY_X++;
        case 2 :
          OVERLAY_X--;
        case 3 :
          OVERLAY_Y++;
        case 4 :
          OVERLAY_Y--;
      }
    }

    guiGraphics.blit(getTemperatureImage(), OVERLAY_X, OVERLAY_Y, 0, 0, OVERLAY_WIDTH, OVERLAY_HEIGHT, OVERLAY_WIDTH,
        OVERLAY_HEIGHT);
  });

  public static final IGuiOverlay TEMPERATURE_READING = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
    if (!readingEnabled)
      return;

    int OVERLAY_X = 2;
    int OVERLAY_Y = 2;

    poseStack.drawString(Minecraft.getInstance().font,
        Component.literal("Temp: " + ClientTemperatureData.getPlayerTemperature()), OVERLAY_X, OVERLAY_Y,
        ChatFormatting.WHITE.getColor());
  });

  private static ResourceLocation getTemperatureImage() {
    double temperature = ClientTemperatureData.getPlayerTemperature();

    if (temperature > 200)
      return TEMPERATURE_14;
    if (isBetween(temperature, 170, 200))
      return TEMPERATURE_13;
    if (isBetween(temperature, 140, 170))
      return TEMPERATURE_12;
    if (isBetween(temperature, 110, 140))
      return TEMPERATURE_11;
    if (isBetween(temperature, 80, 110))
      return TEMPERATURE_10;
    if (isBetween(temperature, 50, 80))
      return TEMPERATURE_9;
    if (isBetween(temperature, 20, 50))
      return TEMPERATURE_8;
    if (isBetween(temperature, -20, 20))
      return TEMPERATURE_7;
    if (isBetween(temperature, -50, -20))
      return TEMPERATURE_6;
    if (isBetween(temperature, -80, -50))
      return TEMPERATURE_5;
    if (isBetween(temperature, -110, -80))
      return TEMPERATURE_4;
    if (isBetween(temperature, -140, -110))
      return TEMPERATURE_3;
    if (isBetween(temperature, -170, -140))
      return TEMPERATURE_2;
    if (isBetween(temperature, -200, -170))
      return TEMPERATURE_1;
    if (temperature < -200)
      return TEMPERATURE_0;

    return TEMPERATURE_7;
  }

  private static boolean isBetween(double compare, int min, int max) {
    return compare > min && compare <= max;
  }
}
