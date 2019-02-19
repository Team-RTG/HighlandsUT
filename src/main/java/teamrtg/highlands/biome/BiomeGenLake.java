package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenLake extends BiomeGenBaseHighlands {

    public BiomeGenLake(int par1) {

        super(HLBiomeProps.LAKE.getProps());

        decorator.treesPerChunk = 3;
        decorator.grassPerChunk = 12;
        decorator.flowersPerChunk = 0;

        this.spawnableCreatureList.clear();
    }

    public WorldGenAbstractTree genBigTreeChance(Random random) {

        return HighlandsGenerators.poplarGen;
    }
}
