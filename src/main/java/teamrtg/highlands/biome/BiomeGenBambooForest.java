package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenBambooForest extends BiomeGenBaseHighlands {

    public BiomeGenBambooForest(int par1) {

        super(HLBiomeProps.BAMBOO_FOREST.getProps());

        decorator.treesPerChunk = 35;
        decorator.grassPerChunk = 4;
        decorator.flowersPerChunk = 1;

        plants.add(HighlandsGenerators.greenLeaf);
        plants.add(HighlandsGenerators.mcWTulip);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random) {

        return HighlandsGenerators.bambooGen;
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        genStandardOre(2, HighlandsGenerators.hlsand, 0, 72, world, random, pos);
        genStandardOre(decorator.chunkProviderSettings.goldCount / 2, decorator.goldGen, decorator.chunkProviderSettings.goldMinHeight, decorator.chunkProviderSettings.goldMaxHeight, world, random, pos);
    }
}
