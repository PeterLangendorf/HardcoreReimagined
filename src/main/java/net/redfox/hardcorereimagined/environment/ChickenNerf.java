package net.redfox.hardcorereimagined.environment;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import net.redfox.hardcorereimagined.config.ModCommonConfigs;
import net.redfox.hardcorereimagined.util.config.StringParsingUtil;
import net.redfox.hardcorereimagined.util.config.json.JsonConfigReader;

public class ChickenNerf {
  private static final Map<Difficulty, Double> DIFFICULTY_MULTIPLIERS = new HashMap<>();
  private static double cooldown;

  public static void init() {
    cooldown = ModCommonConfigs.EGG_COOLDOWN.get();
    StringParsingUtil.fillMap(DIFFICULTY_MULTIPLIERS, ModCommonConfigs.EGG_TIME_MODIFIERS.get(), Difficulty::byName, Double::parseDouble);
  }

  public static int getCooldown(Difficulty difficulty) {
    return (int) (cooldown * DIFFICULTY_MULTIPLIERS.getOrDefault(difficulty, 1.0));
  }
}
