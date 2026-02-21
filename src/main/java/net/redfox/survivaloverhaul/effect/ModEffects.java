package net.redfox.survivaloverhaul.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.redfox.survivaloverhaul.SurvivalOverhaul;

public class ModEffects {
  public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
      SurvivalOverhaul.MOD_ID);

  public static final RegistryObject<MobEffect> HYPOTHERMIA = MOB_EFFECTS.register("hypothermia",
      () -> new HypothermiaEffect(MobEffectCategory.HARMFUL, 0x7ae9ff).addAttributeModifier(Attributes.MOVEMENT_SPEED,
          "7107DE5E-7CE8-4030-940E-514C1F160891", -0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL));

  public static final RegistryObject<MobEffect> HEAT_STROKE = MOB_EFFECTS.register("heat_stroke",
      () -> new HeatStrokeEffect(MobEffectCategory.HARMFUL, 0xfa7223).addAttributeModifier(Attributes.ATTACK_DAMAGE,
          "7107DE5E-7CE8-4030-940E-514C1F160889", -0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL));

  public static void register(IEventBus bus) {
    MOB_EFFECTS.register(bus);
  }
}
