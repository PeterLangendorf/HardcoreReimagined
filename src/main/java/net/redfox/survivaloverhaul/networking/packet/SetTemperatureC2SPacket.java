package net.redfox.survivaloverhaul.networking.packet;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.redfox.survivaloverhaul.temperature.PlayerTemperatureProvider;

public class SetTemperatureC2SPacket {
  private final double temperature;

  public SetTemperatureC2SPacket(double temperature) {
    this.temperature = temperature;
  }

  public SetTemperatureC2SPacket(FriendlyByteBuf buf) {
    this.temperature = buf.readDouble();
  }

  public void toBytes(FriendlyByteBuf buf) {
    buf.writeDouble(temperature);
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();
    context.enqueueWork(() -> {
      ServerPlayer player = context.getSender();

      if (player != null)
        player.getCapability(PlayerTemperatureProvider.PLAYER_TEMPERATURE).ifPresent(playerTemperature -> {
          playerTemperature.setTemperature(temperature);
        });
    });
    return true;
  }
}
