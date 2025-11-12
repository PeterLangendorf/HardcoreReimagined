package net.redfox.hardcorereimagined.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.redfox.hardcorereimagined.networking.ModPackets;
import net.redfox.hardcorereimagined.networking.packet.SetTemperatureC2SPacket;

public class SetTemperature {
  public SetTemperature(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(
        Commands.literal("temperature")
            .requires(commandSource -> commandSource.hasPermission(2))
            .then(
                Commands.literal("set")
                    .then(
                        Commands.argument("value", FloatArgumentType.floatArg())
                            .executes(SetTemperature::setTemperature))));
  }

  private static int setTemperature(CommandContext<CommandSourceStack> context) {
    float value = FloatArgumentType.getFloat(context, "value");
    if (context.getSource().getPlayer() != null)
      context
          .getSource()
          .getPlayer()
          .sendSystemMessage(Component.literal("Set current temperature to: " + value));
    ModPackets.sendToServer(new SetTemperatureC2SPacket(value));
    return 1;
  }
}
