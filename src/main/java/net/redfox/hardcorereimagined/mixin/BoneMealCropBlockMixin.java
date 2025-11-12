package net.redfox.hardcorereimagined.mixin;

import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public abstract class BoneMealCropBlockMixin {
  @Inject(method = "getBonemealAgeIncrease", at = @At("HEAD"), cancellable = true)
  protected void getBonemealAgeIncrease(Level pLevel, CallbackInfoReturnable<Integer> cir) {
    cir.setReturnValue(
        switch (pLevel.getDifficulty()) {
          case PEACEFUL -> Mth.nextInt(pLevel.random, 2, 5);
          case EASY -> Mth.nextInt(pLevel.random, 1, 4);
          case NORMAL -> Mth.nextInt(pLevel.random, 0, 2);
          case HARD -> 0;
        });
  }
}
