package net.redfox.hardcorereimagined.food;

import net.redfox.hardcorereimagined.config.FormattedConfigValues;

public record FoodCategory(int hunger, double saturationMultiplier, int maxStackSize, String name) {
  public static FoodCategory getFromString(String s) {
    for (FoodCategory foodCategory : FormattedConfigValues.FoodNerf.FOOD_CATEGORIES) {
      if (s.equals(foodCategory.name())) {
        return foodCategory;
      }
    }
    return null;
  }
}
