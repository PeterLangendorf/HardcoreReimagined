package net.redfox.hardcorereimagined.food.foodHistory;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.registries.ForgeRegistries;
import net.redfox.hardcorereimagined.HardcoreReimagined;
import net.redfox.hardcorereimagined.client.ClientFoodHistoryData;
import net.redfox.hardcorereimagined.config.ModCommonConfigs;
import net.redfox.hardcorereimagined.util.TooltipHandler;
import oshi.util.tuples.Pair;

@AutoRegisterCapability
public class PlayerFoodHistory {
  private ArrayList<String> foodHistory = new ArrayList<>();

  public ArrayList<String> getFoodHistory() {
    return foodHistory;
  }

  public void addFood(String item) {
    if (!(foodHistory.size() < ModCommonConfigs.MAX_HISTORY.get()))
      foodHistory.remove(foodHistory.size() - 1);
    foodHistory.add(0, item);
  }

  public void copyFrom(PlayerFoodHistory source) {
    this.foodHistory = source.foodHistory;
  }

  public void saveNBTData(CompoundTag nbt) {
    ListTag list = new ListTag();
    for (String item : foodHistory) {
      list.add(StringTag.valueOf(item));
    }
    nbt.put("foodHistory", list);
  }

  public void loadNBTData(CompoundTag nbt) {
    ArrayList<String> temp = new ArrayList<>();
    ListTag list = nbt.getList("foodHistory", StringTag.TAG_STRING);
    for (int i = 0; i < list.size(); i++) {
      temp.add(list.getString(i));
    }
    foodHistory = temp;
  }

  public static void appendNutritionStats(ItemStack stack, List<Component> tooltip) {
    Pair<Integer, Double> multiplierAndSum =
        getMultiplierAndSum(ClientFoodHistoryData.get(), getItemNameFromStack(stack));
    final int sum = multiplierAndSum.getA();
    final double multiplier = multiplierAndSum.getB();

    tooltip.add(
        TooltipHandler.color(
            Component.translatable(
                "tooltip." + HardcoreReimagined.MOD_ID + ".nutritional_value",
                TooltipHandler.color(
                    Component.literal(multiplier * 100 + "%"),
                    TooltipHandler.getColorFromPercentage(multiplier * 100))),
            ChatFormatting.GRAY));
    if (sum != 0) {
      tooltip.add(
          TooltipHandler.colorWithItalics(
              Component.translatable(
                  "tooltip." + HardcoreReimagined.MOD_ID + ".times_eaten",
                  TooltipHandler.getWordingFromNumber(sum),
                  ModCommonConfigs.MAX_HISTORY.get()),
              ChatFormatting.DARK_AQUA));
    } else {
      tooltip.add(
          TooltipHandler.colorWithItalics(
              Component.translatable(
                  "tooltip." + HardcoreReimagined.MOD_ID + ".not_recently_eaten"),
              ChatFormatting.DARK_AQUA));
    }
  }

  public static Pair<Integer, Double> getMultiplierAndSum(
      ArrayList<String> foodHistory, String item) {
    int sum = 0;
    for (String food : foodHistory) {
      if (food.equals(item)) {
        sum++;
      }
    }

    if (sum > ModCommonConfigs.NUTRITION_DECAY.get().size() - 1)
      return new Pair<>(
          sum,
          ModCommonConfigs.NUTRITION_DECAY
              .get()
              .get(ModCommonConfigs.NUTRITION_DECAY.get().size() - 1));
    else if (!(sum == 0))
      return new Pair<>(sum, ModCommonConfigs.NUTRITION_DECAY.get().get(sum - 1));
    else return new Pair<>(0, 1.0);
  }

  public static String getItemNameFromStack(ItemStack stack) {
    ResourceLocation name = ForgeRegistries.ITEMS.getKey(stack.getItem());
    return (name != null) ? name.toString() : getNoItem();
  }

  private static String getNoItem() {
    HardcoreReimagined.LOGGER.error("Player ate a non-existent item! This could break things...");
    return "minecraft:air";
  }
}
