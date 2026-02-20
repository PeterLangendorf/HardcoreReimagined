package net.redfox.survivaloverhaul.mixin.environment;

import net.minecraft.world.entity.animal.Animal;
import net.redfox.survivaloverhaul.config.ConfigUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Animal.class)
public abstract class BreedingTimeMixin {
  @Unique
  private Animal survivaloverhaul$self() {
    return (Animal) (Object) this;
  }

  @ModifyArg(method = "finalizeSpawnChildFromBreeding", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Animal;setAge(I)V"))
  private int modifyBreedingTime(int time) {
    int newValue = ConfigUtil.getBreedingCooldown(survivaloverhaul$self().level().getDifficulty());
    return survivaloverhaul$self().level().getRandom().nextInt(newValue) + newValue;
  }
}