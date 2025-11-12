package net.redfox.hardcorereimagined.mixin;

import net.minecraft.world.entity.AgeableMob;
import net.redfox.hardcorereimagined.config.PublishedConfigValues;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AgeableMob.class)
public abstract class AgeableMobMixin {
  @Inject(method = "setBaby", at = @At("HEAD"), cancellable = true)
  public void setBaby(boolean pBaby, CallbackInfo ci) {
    AgeableMob thisObject = ((AgeableMob) (Object) this);
    thisObject.setAge(
        pBaby
            ? -24000
                * PublishedConfigValues.BABY_GROWTH_MULTIPLIERS.get(
                    thisObject.level().getDifficulty())
            : 0);
    ci.cancel();
  }
}
