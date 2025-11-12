package net.redfox.hardcorereimagined.networking.packet;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.redfox.hardcorereimagined.client.ClientTemperatureData;

public class TemperatureDataSyncS2CPacket {
  private final double temperature;

  public TemperatureDataSyncS2CPacket(double temperature) {
    this.temperature = temperature;
  }

  public TemperatureDataSyncS2CPacket(FriendlyByteBuf buf) {
    this.temperature = buf.readFloat();
  }

  public void toBytes(FriendlyByteBuf buf) {
    buf.writeDouble(temperature);
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();
    context.enqueueWork(
        () -> {
          ClientTemperatureData.set(temperature);
        });
    return true;
  }
}
