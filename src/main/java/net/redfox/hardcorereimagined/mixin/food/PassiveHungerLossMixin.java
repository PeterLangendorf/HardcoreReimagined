package net.redfox.hardcorereimagined.mixin.food;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodData.class)
public abstract class PassiveHungerLossMixin {
  @Inject(method = "tick", at = @At("HEAD"))
  private void tick(Player pPlayer, CallbackInfo ci) {
    pPlayer.causeFoodExhaustion(0.25F);
  }
}
