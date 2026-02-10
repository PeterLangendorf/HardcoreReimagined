package net.redfox.hardcorereimagined.mixin.environment;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.AgeableMob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AgeableMob.class)
public abstract class BabyAgeMixin {
  @Unique
  private AgeableMob hardcoreReimagined$self() {
    return (AgeableMob) (Object) this;
  }

  @ModifyArg(
      method = "setBaby",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/AgeableMob;setAge(I)V"))
  private int setAge(int pAge) {
    return (hardcoreReimagined$self().level().getDifficulty() == Difficulty.HARD) ? pAge : 1;
  }
}
