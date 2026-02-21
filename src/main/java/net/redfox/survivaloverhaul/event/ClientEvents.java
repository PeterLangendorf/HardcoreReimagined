package net.redfox.survivaloverhaul.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.redfox.survivaloverhaul.SurvivalOverhaul;
import net.redfox.survivaloverhaul.client.TemperatureHudOverlay;
import net.redfox.survivaloverhaul.food.foodHistory.PlayerFoodHistory;

public class ClientEvents {
  @Mod.EventBusSubscriber(modid = SurvivalOverhaul.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
  public static class ClientFoodEvents {
    @SubscribeEvent
    public static void onToolTip(ItemTooltipEvent event) {
      if (!event.getItemStack().isEdible())
        return;
      if (event.getEntity() == null)
        return;

      PlayerFoodHistory.appendNutritionStats(event.getItemStack(), event.getToolTip());
    }
  }

  @Mod.EventBusSubscriber(modid = SurvivalOverhaul.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class ClientTemperatureEvents {
    @SubscribeEvent
    public static void onRegisterGuiOverlaysEvent(RegisterGuiOverlaysEvent event) {
      event.registerAbove(VanillaGuiOverlay.DEBUG_TEXT.id(), "temperature_gauge",
          TemperatureHudOverlay.TEMPERATURE_GAUGE);
      event.registerAbove(VanillaGuiOverlay.DEBUG_TEXT.id(), "temperature_reading",
          TemperatureHudOverlay.TEMPERATURE_READING);
    }
  }
}
