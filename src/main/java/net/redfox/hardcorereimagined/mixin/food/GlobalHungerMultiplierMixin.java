package net.redfox.hardcorereimagined.mixin.food;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Player.class)
public abstract class GlobalHungerMultiplierMixin {
  @Unique
  private Player hardcoreReimagined$self() {
    return (Player) (Object) this;
  }

  @ModifyVariable(method = "causeFoodExhaustion", at = @At("HEAD"), argsOnly = true)
  private float modifyFoodExhaustion(float pExhaustion) {
    return (hardcoreReimagined$self().level().getDifficulty() == Difficulty.HARD)
        ? pExhaustion * 100
        : pExhaustion;
  }
}
