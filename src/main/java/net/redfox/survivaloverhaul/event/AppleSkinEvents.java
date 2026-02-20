package net.redfox.survivaloverhaul.event;

import net.redfox.survivaloverhaul.client.ClientFoodHistoryData;
import net.redfox.survivaloverhaul.food.foodHistory.PlayerFoodHistory;
import squeek.appleskin.api.event.FoodValuesEvent;
import squeek.appleskin.api.food.FoodValues;

public class AppleSkinEvents {
  public static void appleskinDisplay(FoodValuesEvent event) {
    event.modifiedFoodValues =
        new FoodValues(
            (int)
                (PlayerFoodHistory.getMultiplierAndSum(
                            ClientFoodHistoryData.get(),
                            PlayerFoodHistory.getItemNameFromStack(event.itemStack))
                        .getB()
                    * event.modifiedFoodValues.hunger),
            event.modifiedFoodValues.saturationModifier);
  }
}
