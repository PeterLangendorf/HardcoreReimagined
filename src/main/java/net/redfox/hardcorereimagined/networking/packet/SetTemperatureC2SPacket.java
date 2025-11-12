package net.redfox.hardcorereimagined.networking.packet;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.redfox.hardcorereimagined.temperature.PlayerTemperatureProvider;

public class SetTemperatureC2SPacket {
  private final float temperature;

  public SetTemperatureC2SPacket(float temperature) {
    this.temperature = temperature;
  }

  public SetTemperatureC2SPacket(FriendlyByteBuf buf) {
    this.temperature = buf.readFloat();
  }

  public void toBytes(FriendlyByteBuf buf) {
    buf.writeFloat(temperature);
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();
    context.enqueueWork(
        () -> {
          ServerPlayer player = context.getSender();

          if (player != null)
            player
                .getCapability(PlayerTemperatureProvider.PLAYER_TEMPERATURE)
                .ifPresent(
                    playerTemperature -> {
                      playerTemperature.setTemperature(temperature);
                    });
        });
    return true;
  }
}
