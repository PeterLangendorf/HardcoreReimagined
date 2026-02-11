package net.redfox.hardcorereimagined.mixin.environment;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;
import net.redfox.hardcorereimagined.environment.ChickenNerf;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chicken.class)
public abstract class EggMixin {
  @Unique
  private Chicken hardcoreReimagined$self() {
    return (Chicken) (Object) this;
  }

  @Redirect(method = "aiStep", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/animal/Chicken;eggTime:I", opcode = Opcodes.PUTFIELD), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Chicken;playSound(Lnet/minecraft/sounds/SoundEvent;FF)V")))
  private void modifyEggTime(Chicken instance, int value) {
    instance.eggTime = ChickenNerf.getCooldown(instance.level().getDifficulty());
  }

  @Inject(method = "<init>", at = @At("RETURN"))
  private void onConstructed(EntityType<? extends Chicken> type, Level level, CallbackInfo ci) {
    hardcoreReimagined$self().eggTime = ChickenNerf.getCooldown(level.getDifficulty());
  }
}
