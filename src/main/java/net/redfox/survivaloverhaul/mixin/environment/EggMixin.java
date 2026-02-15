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
    int newValue = ConfigUtil.getEggCooldown(instance.level().getDifficulty());
    instance.eggTime = instance.level().getRandom().nextInt(newValue) + newValue;
  }

  @Inject(method = "<init>", at = @At("RETURN"))
  private void onConstructed(EntityType<? extends Chicken> type, Level level, CallbackInfo ci) {
    int newValue = ConfigUtil.getEggCooldown(level.getDifficulty());
    survivaloverhaul$self().eggTime = level.getRandom().nextInt(newValue) + newValue;
  }
}
