package net.redfox.survivaloverhaul.mixin.environment;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;
import net.redfox.survivaloverhaul.util.config.ConfigUtil;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chicken.class)
public abstract class EggMixin {
  @Unique
  private Chicken survivaloverhaul$self() {
    return (Chicken) (Object) this;
  }

  @Redirect(method = "aiStep", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/animal/Chicken;eggTime:I", opcode = Opcodes.PUTFIELD), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Chicken;playSound(Lnet/minecraft/sounds/SoundEvent;FF)V")))
  private void modifyEggTime(Chicken instance, int value) {
    instance.eggTime = ConfigUtil.getEggCooldown(instance.level().getDifficulty());
  }

  @Inject(method = "<init>", at = @At("RETURN"))
  private void onConstructed(EntityType<? extends Chicken> type, Level level, CallbackInfo ci) {
    survivaloverhaul$self().eggTime = ConfigUtil.getEggCooldown(level.getDifficulty());
  }
}
