package net.redfox.hardcorereimagined.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Animal;
import net.redfox.hardcorereimagined.config.PublishedConfigValues;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Animal.class)
public abstract class AnimalMixin {
  @Inject(method = "finalizeSpawnChildFromBreeding", at = @At("TAIL"))
  public void finalizeSpawnChildFromBreeding(
      ServerLevel pLevel, Animal pAnimal, AgeableMob pBaby, CallbackInfo ci) {
    Animal thisObject = (Animal) (Object) this;
    thisObject.setAge(
        6000 * PublishedConfigValues.BREEDING_COOLDOWN_MULTIPLIERS.get(pLevel.getDifficulty()));
    pAnimal.setAge(
        6000 * PublishedConfigValues.BREEDING_COOLDOWN_MULTIPLIERS.get(pLevel.getDifficulty()));
  }
}
