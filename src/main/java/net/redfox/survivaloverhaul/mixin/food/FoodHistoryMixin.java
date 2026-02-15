package net.redfox.survivaloverhaul.mixin.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.redfox.survivaloverhaul.client.ClientFoodHistoryData;
import net.redfox.survivaloverhaul.food.foodHistory.PlayerFoodHistory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class FoodHistoryMixin {
  @Redirect(method = "eat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodData;eat(Lnet/minecraft/world/item/Item;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)V"), remap = false)
  private void modifyFoodStats(FoodData instance, Item item, ItemStack stack, LivingEntity entity) {
    final double multiplier = PlayerFoodHistory.getMultiplierAndSum(ClientFoodHistoryData.get(), PlayerFoodHistory.getItemNameFromStack(stack)).getB();
    if (item.isEdible()) {
      FoodProperties properties = stack.getFoodProperties(entity);
      if (properties != null) {
        instance.eat((int) (properties.getNutrition() * multiplier), properties.getSaturationModifier());
      }
    }
  }
}
