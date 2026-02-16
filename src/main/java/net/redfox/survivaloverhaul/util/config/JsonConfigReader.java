package net.redfox.survivaloverhaul.util.config;

import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.fml.loading.FMLPaths;
import net.redfox.survivaloverhaul.SurvivalOverhaul;

public class JsonConfigReader {
  public static final Runnable BIOMES =
      () ->
          writeJsonFile(
              getFilePathAsString("temperature/biomes"),
              createDefaultJsonObject(
                  createJsonArray(
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:ocean")
                          .add("temperature", -20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:deep_ocean")
                          .add("temperature", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:warm_ocean")
                          .add("temperature", 20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:lukewarm_ocean")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:deep_lukewarm_ocean")
                          .add("temperature", -5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:cold_ocean")
                          .add("temperature", -40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:deep_cold_ocean")
                          .add("temperature", -50)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:frozen_ocean")
                          .add("temperature", -60)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:deep_frozen_ocean")
                          .add("temperature", -70)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:mushroom_fields")
                          .add("temperature", 0)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:jagged_peaks")
                          .add("temperature", -80)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:frozen_peaks")
                          .add("temperature", -100)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:stony_peaks")
                          .add("temperature", -60)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:meadow")
                          .add("temperature", -10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:cherry_grove")
                          .add("temperature", 10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:grove")
                          .add("temperature", -50)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:windswept_hills")
                          .add("temperature", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:windswept_gravelly_hills")
                          .add("temperature", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:windswept_forest")
                          .add("temperature", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:forest")
                          .add("temperature", 10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:flower_forest")
                          .add("temperature", 10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:taiga")
                          .add("temperature", -10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:old_growth_pine_taiga")
                          .add("temperature", -20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:old_growth_spruce_taiga")
                          .add("temperature", -20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:snowy_taiga")
                          .add("temperature", -40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:birch_forest")
                          .add("temperature", 10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:old_growth_birch_forest")
                          .add("temperature", 10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:dark_forest")
                          .add("temperature", 40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:pale_garden")
                          .add("temperature", -70)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:jungle")
                          .add("temperature", 90)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:sparse_jungle")
                          .add("temperature", 70)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:bamboo_jungle")
                          .add("temperature", 80)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:river")
                          .add("temperature", -20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:frozen_river")
                          .add("temperature", -80)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:swamp")
                          .add("temperature", 60)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:mangrove_swamp")
                          .add("temperature", 90)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:beach")
                          .add("temperature", 30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:snowy_beach")
                          .add("temperature", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:stony_shore")
                          .add("temperature", -20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:plains")
                          .add("temperature", 0)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:sunflower_plains")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:snowy_plains")
                          .add("temperature", -40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:ice_spikes")
                          .add("temperature", -70)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:desert")
                          .add("temperature", 120)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:savanna")
                          .add("temperature", 70)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:savanna_plateau")
                          .add("temperature", 70)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:windswept_savanna")
                          .add("temperature", 65)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:badlands")
                          .add("temperature", 140)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:wooded_badlands")
                          .add("temperature", 130)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:eroded_badlands")
                          .add("temperature", 150)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:deep_dark")
                          .add("temperature", -150)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:dripstone_caves")
                          .add("temperature", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:lush_caves")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:the_void")
                          .add("temperature", 0)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:nether_wastes")
                          .add("temperature", 200)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:soul_sand_valley")
                          .add("temperature", 190)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:crimson_forest")
                          .add("temperature", 220)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:warped_forest")
                          .add("temperature", 80)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:basalt_deltas")
                          .add("temperature", 230)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:the_end")
                          .add("temperature", -400)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:small_end_islands")
                          .add("temperature", -400)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:end_midlands")
                          .add("temperature", -400)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:end_highlands")
                          .add("temperature", -400)
                          .build(),
                      new JsonObjectBuilder()
                          .add("biome", "minecraft:end_barrens")
                          .add("temperature", -400)
                          .build())));
  public static final Runnable INSULATORS =
      () ->
          writeJsonFile(
              getFilePathAsString("temperature/insulators"),
              createDefaultJsonObject(
                  createJsonArray(
                      new JsonObjectBuilder()
                          .add("block", "minecraft:torch")
                          .add("temperature", 15)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:wall_torch")
                          .add("temperature", 15)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:fire")
                          .add("temperature", 20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:lantern")
                          .add("temperature", 25)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:campfire")
                          .add("temperature", 30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:lava")
                          .add("temperature", 60)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:magma_block")
                          .add("temperature", 30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:white_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:orange_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:magenta_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:light_blue_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:yellow_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:lime_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:pink_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:gray_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:light_gray_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:cyan_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:purple_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:blue_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:brown_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:green_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:red_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:black_candle")
                          .add("temperature", 5)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:soul_campfire")
                          .add("temperature", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:soul_torch")
                          .add("temperature", -15)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:soul_wall_torch")
                          .add("temperature", -15)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:soul_lantern")
                          .add("temperature", -25)
                          .build())));
  public static final Runnable INSIDE_BLOCKS =
      () ->
          writeJsonFile(
              getFilePathAsString("temperature/inside_blocks"),
              createDefaultJsonObject(
                  createJsonArray(
                      new JsonObjectBuilder()
                          .add("block", "minecraft:water")
                          .add("temperature", -30)
                          .add("boots", false)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:powder_snow")
                          .add("temperature", -100)
                          .add("boots", false)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:lava")
                          .add("temperature", 100)
                          .add("boots", false)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:snow")
                          .add("temperature", -20)
                          .add("boots", true)
                          .build())));
  public static final Runnable ON_TOP_BLOCKS =
      () ->
          writeJsonFile(
              getFilePathAsString("temperature/on_top_blocks"),
              createDefaultJsonObject(
                  createJsonArray(
                      new JsonObjectBuilder()
                          .add("block", "minecraft:blue_ice")
                          .add("temperature", -60)
                          .add("boots", true)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:packed_ice")
                          .add("boots", true)
                          .add("temperature", -40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:ice")
                          .add("boots", true)
                          .add("temperature", -20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("block", "minecraft:snow_block")
                          .add("boots", true)
                          .add("temperature", -25)
                          .build())));
  public static final Runnable ARMOR_INSULATORS =
      () ->
          writeJsonFile(
              getFilePathAsString("temperature/armor_insulators"),
              createDefaultJsonObject(
                  createJsonArray(
                      new JsonObjectBuilder()
                          .add("item", "minecraft:leather_boots")
                          .add("heat_resistance", 2)
                          .add("cold_resistance", 10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:leather_leggings")
                          .add("heat_resistance", 6)
                          .add("cold_resistance", 30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:leather_chestplate")
                          .add("heat_resistance", 8)
                          .add("cold_resistance", 40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:leather_helmet")
                          .add("heat_resistance", 4)
                          .add("cold_resistance", 20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:chainmail_boots")
                          .add("heat_resistance", 30)
                          .add("cold_resistance", 0)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:chainmail_leggings")
                          .add("heat_resistance", 50)
                          .add("cold_resistance", 0)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:chainmail_chestplate")
                          .add("heat_resistance", 60)
                          .add("cold_resistance", 0)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:chainmail_helmet")
                          .add("heat_resistance", 40)
                          .add("cold_resistance", 0)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:iron_boots")
                          .add("heat_resistance", -10)
                          .add("cold_resistance", -10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:iron_leggings")
                          .add("heat_resistance", -30)
                          .add("cold_resistance", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:iron_chestplate")
                          .add("heat_resistance", -40)
                          .add("cold_resistance", -40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:iron_helmet")
                          .add("heat_resistance", -20)
                          .add("cold_resistance", -20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:gold_boots")
                          .add("heat_resistance", 10)
                          .add("cold_resistance", 10)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:gold_leggings")
                          .add("heat_resistance", 30)
                          .add("cold_resistance", 30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:gold_chestplate")
                          .add("heat_resistance", 40)
                          .add("cold_resistance", 40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:gold_helmet")
                          .add("heat_resistance", 20)
                          .add("cold_resistance", 20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:diamond_boots")
                          .add("heat_resistance", -20)
                          .add("cold_resistance", -20)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:diamond_leggings")
                          .add("heat_resistance", -40)
                          .add("cold_resistance", -40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:diamond_chestplate")
                          .add("heat_resistance", -50)
                          .add("cold_resistance", -50)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:diamond_helmet")
                          .add("heat_resistance", -30)
                          .add("cold_resistance", -30)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:netherite_boots")
                          .add("heat_resistance", 40)
                          .add("cold_resistance", -40)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:netherite_leggings")
                          .add("heat_resistance", 60)
                          .add("cold_resistance", -60)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:netherite_chestplate")
                          .add("heat_resistance", 70)
                          .add("cold_resistance", -70)
                          .build(),
                      new JsonObjectBuilder()
                          .add("item", "minecraft:netherite_helmet")
                          .add("heat_resistance", 50)
                          .add("cold_resistance", -50)
                          .build())));
  public static final Runnable CROP_NERF =
      () ->
          writeJsonFile(
              getFilePathAsString("environment/crop_nerf"),
              createDefaultJsonObject(
                  createJsonArray(
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:wheat")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:meadow")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:cherry_grove")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:flower_forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:birch_forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sparse_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:plains")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sunflower_plains")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:carrots")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:meadow")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:cherry_grove")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:flower_forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:birch_forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sparse_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:plains")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sunflower_plains")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:potatoes")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:meadow")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:cherry_grove")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:flower_forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:birch_forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sparse_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:plains")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sunflower_plains")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:beetroots")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:meadow")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:cherry_grove")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:flower_forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:birch_forest")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sparse_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:plains")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sunflower_plains")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:pumpkin_stem")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sparse_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:bamboo_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:savanna")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:savanna_plateau")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:windswept_savanna")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:melon_stem")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sparse_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:bamboo_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:savanna")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:savanna_plateau")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:windswept_savanna")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:bamboo")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sparse_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:bamboo_jungle")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:cocoa")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:sparse_jungle")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:bamboo_jungle")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:sugar_cane")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:river")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:swamp")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:beach")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:savanna")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:savanna_plateau")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:windswept_savanna")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:sweet_berry_bush")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:taiga")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:old_growth_pine_taiga")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:old_growth_spruce_taiga")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:cactus")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:desert")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:badlands")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:eroded_badlands")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:kelp")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:ocean")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:deep_ocean")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:warm_ocean")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:lukewarm_ocean")
                                      .add("multiplier", 0.5)
                                      .build(),
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:deep_lukewarm_ocean")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:cave_vines")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "minecraft:lush_caves")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build(),
                      new JsonObjectBuilder()
                          .add("crop", "minecraft:nether_wart")
                          .add("default_multiplier", 0.1)
                          .add(
                              "biome_overrides",
                              createJsonArray(
                                  new JsonObjectBuilder()
                                      .add("biome", "#minecraft:is_nether")
                                      .add("multiplier", 0.5)
                                      .build()))
                          .build())));
  public static final Runnable FOOD_TYPES = () -> writeJsonFile(getFilePathAsString("food/food_types"), createDefaultJsonObject(
      createJsonArray(
          new JsonObjectBuilder().add("name", "morsel").add("food_value", 1).add("saturation_multiplier", 0.5).add("stack_size", 16).build(),
          new JsonObjectBuilder().add("name", "snack").add("food_value", 2).add("saturation_multiplier", 0.75).add("stack_size", 8).build(),
          new JsonObjectBuilder().add("name", "light_meal").add("food_value", 3).add("saturation_multiplier", 1.0).add("stack_size", 4).build(),
          new JsonObjectBuilder().add("name", "meal").add("food_value", 4).add("saturation_multiplier", 1.25).add("stack_size", 2).build(),
          new JsonObjectBuilder().add("name", "heavy_meal").add("food_value", 5).add("saturation_multiplier", 1.5).add("stack_size", 1).build(),
          new JsonObjectBuilder().add("name", "feast").add("food_value", 6).add("saturation_multiplier", 2.0).add("stack_size", 1).build()
      )
  ));
  public static final Runnable FOOD_OVERRIDES = () -> writeJsonFile(getFilePathAsString("food/food_overrides"), createDefaultJsonObject(
      createJsonArray(
          new JsonObjectBuilder().add("food", "minecraft:apple").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:baked_potato").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:beetroot").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:beetroot_soup").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:bread").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:carrot").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:chorus_fruit").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:cooked_chicken").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:cooked_cod").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:cooked_porkchop").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:cooked_rabbit").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:cooked_salmon").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:cookie").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:dried_kelp").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:enchanted_golden_apple").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:golden_apple").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:glow_berries").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:golden_carrot").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:honey_bottle").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:melon_slice").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:mushroom_stew").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:poisonous_potato").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:potato").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:pufferfish").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:pumpkin_pie").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:rabbit_stew").add("food_type", "feast").build(),
          new JsonObjectBuilder().add("food", "minecraft:beef").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:chicken").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:cod").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:mutton").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:porkchop").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:salmon").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "minecraft:rotten_flesh").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:spider_eye").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:cooked_beef").add("food_type", "heavy_meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:suspicious_stew").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "minecraft:sweet_berries").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "minecraft:tropical_fish").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cabbage").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:tomato").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:onion").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:fried_egg").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:tomato_sauce").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:wheat_dough").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:raw_pasta").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:pumpkin_slice").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cabbage_leaf").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:minced_beef").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:beef_patty").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:chicken_cuts").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cooked_chicken_cuts").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:bacon").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cooked_bacon").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cod_slice").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cooked_cod_slice").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:salmon_slice").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cooked_salmon_slice").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:mutton_chops").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cooked_mutton_chops").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:ham").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:smoked_ham").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:pie_crust").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:apple_pie_slice").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:sweet_berry_cheesecake_slice").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:chocolate_pie_slice").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cake_slice").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:sweet_berry_cookie").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:honey_cookie").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:melon_popsicle").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:glow_berry_custard").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:fruit_salad").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:mixed_salad").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:nether_salad").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:barbecue_stick").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:egg_sandwich").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:chicken_sandwich").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:hamburger").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:bacon_sandwich").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:mutton_wrap").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:dumplings").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:stuffed_potato").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cabbage_rolls").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:salmon_roll").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cod_roll").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:kelp_roll").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:kelp_roll_slice").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:cooked_rice").add("food_type", "morsel").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:bone_broth").add("food_type", "snack").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:beef_stew").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:chicken_soup").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:vegetable_soup").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:fish_stew").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:fried_rice").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:pumpkin_soup").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:baked_cod_stew").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:noodle_soup").add("food_type", "heavy_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:bacon_and_eggs").add("food_type", "heavy_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:pasta_with_meatballs").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:pasta_with_mutton_chop").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:mushroom_rice").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:roasted_mutton_chops").add("food_type", "heavy_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:vegetable_noodles").add("food_type", "heavy_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:steak_and_potatoes").add("food_type", "heavy_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:ratatouille").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:squid_ink_pasta").add("food_type", "heavy_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:grilled_salmon").add("food_type", "meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:roast_chicken").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:stuffed_pumpkin").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:honey_glazed_ham").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:shepherds_pie").add("food_type", "light_meal").build(),
          new JsonObjectBuilder().add("food", "farmersdelight:dog_food").add("food_type", "snack").build()
      )
  ));

  public static final Runnable WEIGHTS = () -> writeJsonFile(getFilePathAsString("weight/weights"), createDefaultJsonObject(createJsonArray(
      new JsonObjectBuilder().add("item", "#minecraft:anvils").add("weight", 40.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:logs").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "#minecraft:planks").add("weight", 0.125).build(),
      new JsonObjectBuilder().add("item", "#minecraft:leaves").add("weight", 0.01).build(),
      new JsonObjectBuilder().add("item", "#minecraft:saplings").add("weight", 0.02).build(),
      new JsonObjectBuilder().add("item", "#minecraft:small_flowers").add("weight", 0.01).build(),
      new JsonObjectBuilder().add("item", "#minecraft:fences").add("weight", 0.25).build(),
      new JsonObjectBuilder().add("item", "#minecraft:beds").add("weight", 5.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:doors").add("weight", 1.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:trapdoors").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "#minecraft:boats").add("weight", 5.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:chest_boats").add("weight", 7.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:arrows").add("weight", 0.02).build(),
      new JsonObjectBuilder().add("item", "#minecraft:signs").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "#minecraft:wool").add("weight", 0.2).build(),
      new JsonObjectBuilder().add("item", "#minecraft:swords").add("weight", 3.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:pickaxes").add("weight", 4.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:axes").add("weight", 5.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:shovels").add("weight", 2.0).build(),
      new JsonObjectBuilder().add("item", "#minecraft:hoes").add("weight", 2.0).build(),

      new JsonObjectBuilder().add("item", "minecraft:netherite_block").add("weight", 15.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:enchanting_table").add("weight", 10.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:obsidian").add("weight", 3.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:crying_obsidian").add("weight", 3.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:iron_block").add("weight", 4.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:gold_block").add("weight", 4.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:diamond_block").add("weight", 4.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:copper_block").add("weight", 4.5).build(),

      new JsonObjectBuilder().add("item", "minecraft:ancient_debris").add("weight", 4.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:ender_chest").add("weight", 5.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:cauldron").add("weight", 6.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:furnace").add("weight", 4.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:blast_furnace").add("weight", 5.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:chest").add("weight", 2.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:dispenser").add("weight", 2.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:piston").add("weight", 2.0).build(),

      new JsonObjectBuilder().add("item", "minecraft:cobblestone").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:stone").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:deepslate").add("weight", 0.6).build(),
      new JsonObjectBuilder().add("item", "minecraft:diorite").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:granite").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:andesite").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:dirt").add("weight", 0.4).build(),
      new JsonObjectBuilder().add("item", "minecraft:grass_block").add("weight", 0.45).build(),
      new JsonObjectBuilder().add("item", "minecraft:sand").add("weight", 0.4).build(),
      new JsonObjectBuilder().add("item", "minecraft:gravel").add("weight", 0.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:glass").add("weight", 0.2).build(),


      new JsonObjectBuilder().add("item", "minecraft:netherite_chestplate").add("weight", 15.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:netherite_leggings").add("weight", 12.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:netherite_boots").add("weight", 8.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:netherite_helmet").add("weight", 8.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:iron_chestplate").add("weight", 10.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:iron_leggings").add("weight", 8.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:iron_boots").add("weight", 5.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:iron_helmet").add("weight", 5.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:diamond_chestplate").add("weight", 8.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:diamond_leggings").add("weight", 6.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:diamond_boots").add("weight", 4.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:diamond_helmet").add("weight", 4.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:leather_chestplate").add("weight", 3.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:leather_leggings").add("weight", 2.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:leather_boots").add("weight", 1.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:leather_helmet").add("weight", 1.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:shield").add("weight", 4.0).build(),

      new JsonObjectBuilder().add("item", "minecraft:bucket").add("weight", 1.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:water_bucket").add("weight", 4.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:lava_bucket").add("weight", 5.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:milk_bucket").add("weight", 3.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:netherite_ingot").add("weight", 4).build(),
      new JsonObjectBuilder().add("item", "minecraft:iron_ingot").add("weight", 2).build(),
      new JsonObjectBuilder().add("item", "minecraft:gold_ingot").add("weight", 2).build(),
      new JsonObjectBuilder().add("item", "minecraft:copper_ingot").add("weight", 2).build(),
      new JsonObjectBuilder().add("item", "minecraft:raw_iron").add("weight", 2.5).build(),
      new JsonObjectBuilder().add("item", "minecraft:diamond").add("weight", 3).build(),
      new JsonObjectBuilder().add("item", "minecraft:emerald").add("weight", 3).build(),
      new JsonObjectBuilder().add("item", "minecraft:redstone").add("weight", 0.1).build(),

      new JsonObjectBuilder().add("item", "minecraft:golden_apple").add("weight", 1.0).build(),
      new JsonObjectBuilder().add("item", "minecraft:apple").add("weight", 0.25).build(),
      new JsonObjectBuilder().add("item", "minecraft:bread").add("weight", 0.3).build(),
      new JsonObjectBuilder().add("item", "minecraft:baked_potato").add("weight", 0.3).build(),
      new JsonObjectBuilder().add("item", "minecraft:beef").add("weight", 0.2).build(),
      new JsonObjectBuilder().add("item", "minecraft:cooked_beef").add("weight", 0.2).build(),
      new JsonObjectBuilder().add("item", "minecraft:cake").add("weight", 1.0).build(),

      new JsonObjectBuilder().add("item", "minecraft:bone").add("weight", 0.1).build(),
      new JsonObjectBuilder().add("item", "minecraft:gunpowder").add("weight", 0.05).build(),
      new JsonObjectBuilder().add("item", "minecraft:rotten_flesh").add("weight", 0.1).build(),
      new JsonObjectBuilder().add("item", "minecraft:ender_pearl").add("weight", 0.2).build(),
      new JsonObjectBuilder().add("item", "minecraft:slime_ball").add("weight", 0.1).build(),
      new JsonObjectBuilder().add("item", "minecraft:leather").add("weight", 0.1).build(),

      new JsonObjectBuilder().add("item", "minecraft:feather").add("weight", 0.01).build(),
      new JsonObjectBuilder().add("item", "minecraft:string").add("weight", 0.01).build(),
      new JsonObjectBuilder().add("item", "minecraft:paper").add("weight", 0.01).build(),
      new JsonObjectBuilder().add("item", "minecraft:stick").add("weight", 0.02).build(),
      new JsonObjectBuilder().add("item", "minecraft:wheat_seeds").add("weight", 0.01).build()
  )));

  public static JsonObject getOrCreateJsonFile(String fileName, Runnable create) {
    if (!new File(getFilePathAsString(fileName)).exists()) create.run();
    return readJsonFile(fileName);
  }

  private static void writeJsonFile(String fileName, JsonObject jsonObject) {
    File file = new File(fileName);
    try {
      if (file.getParentFile() != null) {
        file.getParentFile().mkdirs();
      }

      file.createNewFile();

      try (FileWriter writer = new FileWriter(file)) {
        new GsonBuilder().setPrettyPrinting().create().toJson(jsonObject, writer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static JsonObject readJsonFile(String fileName) {
    File file = new File(getFilePathAsString(fileName));
    Gson gson = new Gson();
    try (FileReader reader = new FileReader(file)) {
      return gson.fromJson(reader, JsonObject.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static JsonObject createDefaultJsonObject(JsonElement jsonElement) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("values", jsonElement);
    return jsonObject;
  }

  private static JsonArray createJsonArray(JsonObject... jsonObjects) {
    JsonArray jsonArray = new JsonArray();
    for (JsonObject jsonObject : jsonObjects) {
      jsonArray.add(jsonObject);
    }
    return jsonArray;
  }

  private static String getFilePathAsString(String filePath) {
    return FMLPaths.CONFIGDIR
        .get()
        .resolve(SurvivalOverhaul.MOD_ID + "/" + filePath + ".json")
        .toString();
  }

  public static class JsonObjectBuilder {
    private final List<String> keys;
    private final List<Object> values;

    public JsonObjectBuilder() {
      this.keys = new ArrayList<>();
      this.values = new ArrayList<>();
    }

    public JsonObjectBuilder add(String key, Object value) {
      this.keys.add(key);
      this.values.add(value);
      return this;
    }

    public JsonObject build() {
      JsonObject jsonObject = new JsonObject();
      for (int i = 0; i < this.keys.size(); i++) {
        Object value = this.values.get(i);
        if (value instanceof String s) {
          jsonObject.addProperty(this.keys.get(i), s);
        } else if (value instanceof Number n) {
          jsonObject.addProperty(this.keys.get(i), n);
        } else if (value instanceof Boolean b) {
          jsonObject.addProperty(this.keys.get(i), b);
        } else if (value instanceof JsonElement e) {
          jsonObject.add(this.keys.get(i), e);
        }
      }

      return jsonObject;
    }
  }
}
