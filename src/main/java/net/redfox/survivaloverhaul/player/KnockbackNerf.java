package net.redfox.survivaloverhaul.player;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.redfox.survivaloverhaul.config.ModCommonConfigs;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class KnockbackNerf {
  private static final Set<Entity> CANCEL_KNOCKBACK_SET = Collections.newSetFromMap(new WeakHashMap<>());

  public static void onLivingHurt(LivingHurtEvent event) {
    if (event.getSource().getEntity() instanceof Player player) {
      if (player.level().isClientSide()) {
        return;
      }
      if (!(event.getEntity() instanceof Player)) {
        if (player.getHealth() <= ModCommonConfigs.NO_KNOCKBACK_HEALTH_REQUIREMENT.get()) {
          CANCEL_KNOCKBACK_SET.add(event.getEntity());
        }
      }
    }
  }

  public static void onLivingKnockback(LivingKnockBackEvent event) {
    if (CANCEL_KNOCKBACK_SET.remove(event.getEntity())) {
      event.setCanceled(true);
    }
  }
}
