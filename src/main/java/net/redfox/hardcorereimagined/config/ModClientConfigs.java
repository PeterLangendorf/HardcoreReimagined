package net.redfox.hardcorereimagined.config;

import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;
import net.redfox.hardcorereimagined.HardcoreReimagined;

public class ModClientConfigs {
  public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
  public static final ForgeConfigSpec SPEC;

  public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_MODE;

  static {
    BUILDER.push("Client Configs for " + HardcoreReimagined.MOD_ID);

    DISPLAY_MODE =
        BUILDER
            .comment(
                "The method in which the mod displays your temperature.",
                "Acceptable values: GAUGE, NUMBER, NONE, BOTH")
            .defineInList("displayMode", "GAUGE", List.of("GAUGE", "NUMBER", "NONE", "BOTH"));

    BUILDER.pop();
    SPEC = BUILDER.build();
  }
}
