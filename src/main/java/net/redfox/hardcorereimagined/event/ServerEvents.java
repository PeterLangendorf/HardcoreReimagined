package net.redfox.hardcorereimagined.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import net.redfox.hardcorereimagined.HardcoreReimagined;
import net.redfox.hardcorereimagined.command.GetTemperature;
import net.redfox.hardcorereimagined.command.SetTemperature;
import net.redfox.hardcorereimagined.config.PublishedConfigValues;
import net.redfox.hardcorereimagined.food.foodHistory.PlayerFoodHistoryProvider;
import net.redfox.hardcorereimagined.networking.ModPackets;
import net.redfox.hardcorereimagined.networking.packet.EatFoodC2SPacket;
import net.redfox.hardcorereimagined.networking.packet.FoodHistorySyncS2CPacket;
import net.redfox.hardcorereimagined.networking.packet.TemperatureDataSyncS2CPacket;
import net.redfox.hardcorereimagined.symptom.ModSymptoms;
import net.redfox.hardcorereimagined.temperature.PlayerTemperature;
import net.redfox.hardcorereimagined.temperature.PlayerTemperatureProvider;
import net.redfox.hardcorereimagined.util.HungerHelper;

public class ServerEvents {
  @Mod.EventBusSubscriber(modid = HardcoreReimagined.MOD_ID)
  public static class ServerFoodEvents {
    @SubscribeEvent
    public static void onEatFood(LivingEntityUseItemEvent.Finish event) {
      if (!(event.getEntity() instanceof Player p)) return;
      if (!p.level().isClientSide()) return;
      if (!event.getItem().isEdible()) return;

      ModPackets.sendToServer(
          new EatFoodC2SPacket(HungerHelper.getItemNameFromStack(event.getItem())));
    }

    @SubscribeEvent
    public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
      Player player = event.getEntity();
      player.setHealth(player.getMaxHealth() * 0.5F);
      player.getFoodData().setFoodLevel((int) (20 * 0.5F));
    }
  }

  @Mod.EventBusSubscriber(modid = HardcoreReimagined.MOD_ID)
  public static class ServerAnimalEvents {
    @SubscribeEvent
    public static void onLivingEntitySpawn(MobSpawnEvent.FinalizeSpawn event) {
      if (event.getEntity() instanceof Chicken chicken) {
        chicken.eggTime =
            chicken
                    .level()
                    .random
                    .nextInt(
                        PublishedConfigValues.EGG_COOLDOWN
                            * PublishedConfigValues.EGG_COOLDOWN_MULTIPLIER.get(
                                chicken.level().getDifficulty()))
                + PublishedConfigValues.EGG_COOLDOWN
                    * PublishedConfigValues.EGG_COOLDOWN_MULTIPLIER.get(
                        chicken.level().getDifficulty());
      }
    }
  }

  @Mod.EventBusSubscriber(modid = HardcoreReimagined.MOD_ID)
  public static class ServerTemperatureEvents {
    @SubscribeEvent
    public static void onServerTickEvent(TickEvent.ServerTickEvent event) {
      if (event.phase == TickEvent.Phase.END) {
        if (event.getServer().getTickCount() % 20 == 0) {
          for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
            PlayerTemperature.periodicUpdate(player);
            ModSymptoms.periodicUpdate(player);
          }
        }
      }
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
      new GetTemperature(event.getDispatcher());
      new SetTemperature(event.getDispatcher());

      ConfigCommand.register(event.getDispatcher());
    }
  }

  @Mod.EventBusSubscriber(modid = HardcoreReimagined.MOD_ID)
  public static class ServerCapablityEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
      if (event.getObject() instanceof Player) {
        if (!event
            .getObject()
            .getCapability(PlayerFoodHistoryProvider.PLAYER_FOOD_HISTORY)
            .isPresent()) {
          event.addCapability(
              ResourceLocation.fromNamespaceAndPath(HardcoreReimagined.MOD_ID, "hunger_properties"),
              new PlayerFoodHistoryProvider());
        }
        if (!event
            .getObject()
            .getCapability(PlayerTemperatureProvider.PLAYER_TEMPERATURE)
            .isPresent()) {
          event.addCapability(
              ResourceLocation.fromNamespaceAndPath(HardcoreReimagined.MOD_ID, "temp_properties"),
              new PlayerTemperatureProvider());
        }
      }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
      if (event.isWasDeath()) {
        event.getOriginal().reviveCaps();
        event
            .getOriginal()
            .getCapability(PlayerFoodHistoryProvider.PLAYER_FOOD_HISTORY)
            .ifPresent(
                oldStore ->
                    event
                        .getEntity()
                        .getCapability(PlayerFoodHistoryProvider.PLAYER_FOOD_HISTORY)
                        .ifPresent(newStore -> newStore.copyFrom(oldStore)));
      }
      event.getOriginal().invalidateCaps();
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
      if (!event.getLevel().isClientSide()) {
        if (event.getEntity() instanceof ServerPlayer player) {
          player
              .getCapability(PlayerFoodHistoryProvider.PLAYER_FOOD_HISTORY)
              .ifPresent(
                  history ->
                      ModPackets.sendToClient(
                          new FoodHistorySyncS2CPacket(history.getFoodHistory()), player));
          player
              .getCapability(PlayerTemperatureProvider.PLAYER_TEMPERATURE)
              .ifPresent(
                  playerTemperature -> {
                    ModPackets.sendToClient(
                        new TemperatureDataSyncS2CPacket(playerTemperature.getTemperature()),
                        player);
                  });
        }
      }
    }
  }
}
