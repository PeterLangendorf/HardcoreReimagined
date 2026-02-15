package net.redfox.survivaloverhaul.mixin.environment;

import net.minecraft.world.entity.AgeableMob;
import net.redfox.survivaloverhaul.util.config.ConfigUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AgeableMob.class)
public abstract class BabyAgeMixin {
  @Unique
  private AgeableMob survivaloverhaul$self() {
    return (AgeableMob) (Object) this;
  }

  @ModifyArg(
      method = "setBaby",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/AgeableMob;setAge(I)V"))
  private int setAge(int pAge) {
    int newValue = ConfigUtil.getBabyAge(survivaloverhaul$self().level().getDifficulty());
    return -(survivaloverhaul$self().level().getRandom().nextInt(newValue) + newValue);
  }
}
