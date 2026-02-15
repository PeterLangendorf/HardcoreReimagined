package net.redfox.survivaloverhaul.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.redfox.survivaloverhaul.client.ClientTemperatureData;

public class  GetTemperature {
  public GetTemperature(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(
        Commands.literal("temperature")
            .then(
                Commands.literal("get")
                    .executes((command) -> getTemperature(command.getSource()))));
  }

  private int getTemperature(CommandSourceStack context) {
    if (context.getPlayer() != null)
      context
          .getPlayer()
          .sendSystemMessage(
              Component.literal(
                  "Your current temperature is: " + ClientTemperatureData.getPlayerTemperature()));
    return Math.toIntExact(Math.round(ClientTemperatureData.getPlayerTemperature()));
  }
}
