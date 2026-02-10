package net.redfox.hardcorereimagined.mixin.environment;

import net.minecraft.world.level.block.CropBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CropBlock.class)
public abstract class BoneMealMixin {
  @Unique
  private CropBlock hardcoreReimagined$self() {
    return (CropBlock) (Object) this;
  }

  @ModifyArg(method = "getBonemealAgeIncrease", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;nextInt(Lnet/minecraft/util/RandomSource;II)I"), index = 1)
  private int modifyLowerBound(int pMinimum) {
    return 0;
  }

  @ModifyArg(method = "getBonemealAgeIncrease", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;nextInt(Lnet/minecraft/util/RandomSource;II)I"), index = 2)
  private int modifyUpperBound(int pMaximum) {
    return 1;
  }
}
