package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenPinelands extends BiomeGenBaseHighlands {

    public BiomeGenPinelands(int par1) {

        super(HLBiomeProps.PINELANDS.getProps());

        decorator.treesPerChunk = 3;
        decorator.grassPerChunk = 6;
        decorator.flowersPerChunk = 0;

        plants.add(HighlandsGenerators.thornbush);
        plants.add(HighlandsGenerators.blueberryBush);
        plants.add(HighlandsGenerators.raspberryBush);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random) {

        return (par1Random.nextInt(2) == 0 ? HighlandsGenerators.shrubGen : new WorldGenTaiga2(false));
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        genStandardOre(decorator.chunkProviderSettings.ironCount / 2, decorator.ironGen, decorator.chunkProviderSettings.ironMinHeight, decorator.chunkProviderSettings.ironMaxHeight, world, random, pos);

        int i = 3 + random.nextInt(6);
        int j;
        int k;
        int l;

        for (j = 0; j < i; ++j) {
            k = random.nextInt(16);
            l = random.nextInt(28) + 4;
            int i1 = random.nextInt(16);
            BlockPos blockpos1 = pos.add(k, l, i1);

            if (world.getBlockState(blockpos1).getBlock().isReplaceableOreGen(world.getBlockState(blockpos1), world, blockpos1, net.minecraft.block.state.pattern.BlockMatcher.forBlock(Blocks.STONE))) {
                world.setBlockState(blockpos1, Blocks.EMERALD_ORE.getDefaultState(), 2);
            }
        }
    }
}
