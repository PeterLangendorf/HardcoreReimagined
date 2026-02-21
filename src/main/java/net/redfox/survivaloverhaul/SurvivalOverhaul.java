package net.redfox.survivaloverhaul;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.redfox.survivaloverhaul.client.TemperatureHudOverlay;
import net.redfox.survivaloverhaul.config.ModClientConfigs;
import net.redfox.survivaloverhaul.config.ModCommonConfigs;
import net.redfox.survivaloverhaul.effect.ModEffects;
import net.redfox.survivaloverhaul.config.ConfigUtil;
import net.redfox.survivaloverhaul.environment.CropNerf;
import net.redfox.survivaloverhaul.event.AppleSkinEvents;
import net.redfox.survivaloverhaul.food.FoodNerf;
import net.redfox.survivaloverhaul.networking.ModPackets;
import net.redfox.survivaloverhaul.player.KnockbackNerf;
import net.redfox.survivaloverhaul.player.RespawnNerf;
import org.slf4j.Logger;

@Mod(SurvivalOverhaul.MOD_ID)
public class SurvivalOverhaul {
  public static final String MOD_ID = "survivaloverhaul";
  public static final Logger LOGGER = LogUtils.getLogger();

  public SurvivalOverhaul(FMLJavaModLoadingContext context) {
    IEventBus modEventBus = context.getModEventBus();

    context.registerConfig(
        ModConfig.Type.COMMON, ModCommonConfigs.SPEC, SurvivalOverhaul.MOD_ID + "/common.toml");
    context.registerConfig(
        ModConfig.Type.CLIENT, ModClientConfigs.SPEC, SurvivalOverhaul.MOD_ID + "/client.toml");

    ModEffects.register(modEventBus);

    modEventBus.addListener(this::commonSetup);
    MinecraftForge.EVENT_BUS.addListener(CropNerf::onCropGrowth);
    MinecraftForge.EVENT_BUS.register(this);

    if (ModList.get().isLoaded("appleskin")) {
      MinecraftForge.EVENT_BUS.addListener(AppleSkinEvents::appleskinDisplay);
    }
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    ModPackets.init();
    TemperatureHudOverlay.init();
    if (ModCommonConfigs.FOOD_MODIFICATION_ENABLED.get()) FoodNerf.init();
    ConfigUtil.init();
    if (ModClientConfigs.FOOD_TYPE_TOOLTIP_DISPLAY.get())
      MinecraftForge.EVENT_BUS.addListener(FoodNerf::addTooltip);
    if (ModCommonConfigs.NO_KNOCKBACK_ENABLED.get()) {
      MinecraftForge.EVENT_BUS.addListener(KnockbackNerf::onLivingKnockback);
      MinecraftForge.EVENT_BUS.addListener(KnockbackNerf::onLivingHurt);
    }
    if (ModCommonConfigs.SPAWN_MODIFIERS_ENABLED.get()) MinecraftForge.EVENT_BUS.addListener(RespawnNerf::onRespawn);
  }
}
