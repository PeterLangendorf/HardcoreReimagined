package net.redfox.hardcorereimagined.mixin.environment;

import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Animal.class)
public abstract class BreedingTimeMixin {
  @Unique
  private Animal hardcoreReimagined$self() {
    return (Animal) (Object) this;
  }

  @ModifyArg(method = "finalizeSpawnChildFromBreeding", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Animal;setAge(I)V"))
  private int modifyBreedingTime(int time) {
    return 1;
  }
}