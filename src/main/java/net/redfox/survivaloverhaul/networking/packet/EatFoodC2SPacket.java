package net.redfox.survivaloverhaul.networking.packet;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.redfox.survivaloverhaul.food.foodHistory.PlayerFoodHistoryProvider;
import net.redfox.survivaloverhaul.networking.ModPackets;

public class EatFoodC2SPacket {
  private final String foodName;

  public EatFoodC2SPacket(String foodName) {
    this.foodName = foodName;
  }

  public EatFoodC2SPacket(FriendlyByteBuf buf) {
    foodName = buf.readUtf();
  }

  public void toBytes(FriendlyByteBuf buf) {
    buf.writeUtf(foodName);
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();
    context.enqueueWork(
        () -> {
          ServerPlayer player = context.getSender();
          player
              .getCapability(PlayerFoodHistoryProvider.PLAYER_FOOD_HISTORY)
              .ifPresent(
                  history -> {
                    history.addFood(foodName);
                    ModPackets.sendToClient(
                        new FoodHistorySyncS2CPacket(history.getFoodHistory()), player);
                  });
        });
    return true;
  }
}
