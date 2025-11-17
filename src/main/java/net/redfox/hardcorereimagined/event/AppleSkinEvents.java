package net.redfox.hardcorereimagined.event;

import net.redfox.hardcorereimagined.client.ClientFoodHistoryData;
import net.redfox.hardcorereimagined.food.foodHistory.PlayerFoodHistory;
import squeek.appleskin.api.event.FoodValuesEvent;
import squeek.appleskin.api.food.FoodValues;

public class AppleSkinEvents {
  public static void onAppleSkinFoodEvent(FoodValuesEvent event) {
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
