package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenLake extends BiomeGenBaseHighlands {

    public BiomeGenLake(int par1) {

        super(HLBiomeProps.LAKE.getProps());

        theBiomeDecorator.treesPerChunk = 3;
        theBiomeDecorator.grassPerChunk = 12;
        theBiomeDecorator.flowersPerChunk = 0;

        this.spawnableCreatureList.clear();
    }

    public WorldGenAbstractTree genBigTreeChance(Random random) {

        return HighlandsGenerators.poplarGen;
    }
}
