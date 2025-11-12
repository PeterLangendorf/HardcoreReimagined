package net.redfox.hardcorereimagined.temperature;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.redfox.hardcorereimagined.config.FormattedConfigValues;
import net.redfox.hardcorereimagined.effect.HeatStrokeEffect;
import net.redfox.hardcorereimagined.effect.HypothermiaEffect;
import net.redfox.hardcorereimagined.networking.ModPackets;
import net.redfox.hardcorereimagined.networking.packet.TemperatureDataSyncS2CPacket;
import net.redfox.hardcorereimagined.util.MathHelper;
import oshi.util.tuples.Pair;

@AutoRegisterCapability
public class PlayerTemperature {
  private double temperature = 0;

  public double getTemperature() {
    return MathHelper.roundToOneDecimal(temperature);
  }

  public void setTemperature(double temperature) {
    this.temperature = MathHelper.roundToOneDecimal(temperature);
  }

  public void approachTemperature(double goal) {
    double difference =
        MathHelper.roundToOneDecimal(
            ((Math.max(0.1, Math.min(5, Math.abs(goal - temperature) / 10))) * 10) / 10.0F);

    if (temperature > goal) {
      temperature -= difference;
    } else if (temperature < goal) {
      temperature += difference;
    }
  }

  public void saveNBTData(CompoundTag nbt) {
    nbt.putDouble("temperature", MathHelper.roundToOneDecimal(temperature));
  }

  public void loadNBTData(CompoundTag nbt) {
    temperature = MathHelper.roundToOneDecimal(nbt.getDouble("temperature"));
  }

  public static void periodicUpdate(ServerPlayer player) {
    player
        .getCapability(PlayerTemperatureProvider.PLAYER_TEMPERATURE)
        .ifPresent(
            playerTemperature -> {
              double approachingTemperature = PlayerTemperature.calculateTemperatureGoal(player);
              double temp = playerTemperature.getTemperature();
              if (temp >= 80) {
                HeatStrokeEffect.applyStandardEffect(player, temp);
              } else if (temp <= -80) {
                HypothermiaEffect.applyStandardEffect(player, temp);
              }
              playerTemperature.approachTemperature(approachingTemperature);
              ModPackets.sendToClient(
                  new TemperatureDataSyncS2CPacket(playerTemperature.getTemperature()), player);
            });
  }

  public static double calculateTemperatureGoal(ServerPlayer player) {
    Level level = player.level();
    Block currentBlock = level.getBlockState(player.blockPosition()).getBlock();
    double goalTemperature = 0;
    // Biome
    goalTemperature +=
        FormattedConfigValues.checkMapForValue(
            FormattedConfigValues.Temperature.BIOME_TEMPERATURES,
            level.getBiome(player.blockPosition()).get());

    // Insulators (torches, campfires, lava, fire, magma)
    for (BlockState state :
        (BlockState[])
            level.getBlockStates(player.getBoundingBox().inflate(5)).distinct().toArray()) {
      goalTemperature +=
          FormattedConfigValues.checkMapForValue(
              FormattedConfigValues.Temperature.BLOCK_TEMPERATURES, state.getBlock());
    }

    // Fluids
    goalTemperature +=
        FormattedConfigValues.checkMapForValue(
            FormattedConfigValues.Temperature.FLUID_TEMPERATURES, currentBlock);

    if (player.getItemBySlot(EquipmentSlot.FEET).isEmpty()) {
      goalTemperature +=
          FormattedConfigValues.checkMapForValue(
              FormattedConfigValues.Temperature.BLOCK_TOP_TEMPERATURES,
              level.getBlockState(player.blockPosition().below()).getBlock());
      if (level
          .getBlockState(player.blockPosition())
          .isCollisionShapeFullBlock(level, player.blockPosition()))
        goalTemperature +=
            FormattedConfigValues.checkMapForValue(
                FormattedConfigValues.Temperature.BLOCK_TOP_TEMPERATURES, currentBlock);
    }
    // Rain / snow / thunder
    if (level.isRainingAt(player.blockPosition())) {
      goalTemperature -= 30;
    }
    if (level.isRaining()
        && level.getBiome(player.blockPosition()).value().coldEnoughToSnow(player.blockPosition())
        && level.canSeeSky(player.blockPosition())) {
      goalTemperature -= 60;
    }

    // Day or night

    if (level.isDay() && level.dimension() == Level.OVERWORLD) {
      goalTemperature += 10;
    } else {
      goalTemperature -= 10;
    }

    // On fire

    if (player.getRemainingFireTicks() > 0) {
      goalTemperature += 50;
    }

    // Altitude

    if (player.getY() < 40) {
      goalTemperature -= MathHelper.roundToOneDecimal(Math.abs(((player.getY() - 40) / 5.0F)));
    }
    if (player.getY() > 80) {
      goalTemperature -= MathHelper.roundToOneDecimal(Math.abs(((80 - player.getY()) / 5.0F)));
    }

    int heatResistance = 0;
    int coldResistance = 0;

    for (ItemStack i : player.getArmorSlots()) {
      Pair<Integer, Integer> ints =
          FormattedConfigValues.checkMapForPair(
              FormattedConfigValues.Temperature.ARMOR_INSULATIONS, i.getItem());
      heatResistance += ints.getA();
      coldResistance += ints.getB();

      if (goalTemperature < 0) {
        goalTemperature += coldResistance;
        if (goalTemperature > 0) goalTemperature = 0;
      } else if (goalTemperature > 0) {
        goalTemperature -= heatResistance;
        if (goalTemperature < 0) goalTemperature = 0;
      }
    }

    return goalTemperature
        + (FormattedConfigValues.Temperature.FLUCTUATE_TEMPERATURE.getAsBoolean()
            ? MathHelper.roundToOneDecimal(Math.random() - 0.5F)
            : 0);
  }
}
