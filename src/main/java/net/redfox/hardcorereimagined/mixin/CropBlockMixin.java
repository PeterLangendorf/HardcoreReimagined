package net.redfox.hardcorereimagined.mixin;

import net.minecraft.world.level.block.CropBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin {
    @Unique
    private static Supplier<Map<Block, List<ResourceKey<Biome>>>> VALID_CROP_BIOMES =
        () -> Map.of(Blocks.WHEAT, List.of(Biomes.PLAINS));

    @Shadow
    public abstract int getAge(BlockState pState);

    @Shadow
    public abstract int getMaxAge();

    @Shadow
    public abstract BlockState getStateForAge(int pAge);

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void randomTick(
        BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom, CallbackInfo
   ci) {
      if (!pLevel.isAreaLoaded(pPos, 1)) return;

      if (pLevel.getRawBrightness(pPos, 0) >= 9
          && pLevel.isDay()
          && VALID_CROP_BIOMES
              .get()
              .get(pState.getBlock())
              .contains(pLevel.getBiome(pPos).unwrapKey().get())) {
        int i = this.getAge(pState);
        if (i < this.getMaxAge()) {
          float f = CropBlock.getGrowthSpeed((CropBlock) (Object) this, pLevel, pPos);
          if (ForgeHooks.onCropsGrowPre(
              pLevel,
              pPos,
              pState,
              pRandom.nextInt(
                      (int)
                              (25.0F
                                  * PublishedConfigValues.CROP_GROWTH_MULTIPLIER.get(
                                      pLevel.getDifficulty())
                                  / f)
                          + 1)
                  == 0)) {
            pLevel.setBlock(pPos, this.getStateForAge(i + 1), 2);
            ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
          }
        }
      }
      ci.cancel();
    }
}
