package net.redfox.survivaloverhaul.mixin.environment;

import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.redfox.survivaloverhaul.util.config.ConfigUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public abstract class BoneMealMixin {
  @Inject(method = "getBonemealAgeIncrease", at = @At("HEAD"), cancellable = true)
  private void overrideBonemealIncrease(Level pLevel, CallbackInfoReturnable<Integer> cir) {
    cir.setReturnValue(Mth.nextInt(pLevel.random, ConfigUtil.getBonemealLowerBound(pLevel.getDifficulty()), ConfigUtil.getBonemealUpperBound(pLevel.getDifficulty())));
  }
}
