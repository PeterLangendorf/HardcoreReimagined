package net.redfox.survivaloverhaul.player;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.redfox.survivaloverhaul.config.ModCommonConfigs;

public class RespawnNerf {
  public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
    event.getEntity().setHealth((int) (event.getEntity().getMaxHealth() * ModCommonConfigs.SPAWN_HEALTH_MULTIPLIER.get()));
    event.getEntity().getFoodData().setFoodLevel((int) (event.getEntity().getFoodData().getFoodLevel() * ModCommonConfigs.SPAWN_HUNGER_MULTIPLIER.get()));
  }
}