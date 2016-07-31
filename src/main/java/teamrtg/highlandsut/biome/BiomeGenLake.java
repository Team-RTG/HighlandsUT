package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenLake extends BiomeGenBaseHighlands {

    private static BiomeProperties properties = new Biome.BiomeProperties("Lake")
        .setBaseHeight(-0.7F)
        .setHeightVariation(0.01F)
        .setTemperature(0.8F)
        .setRainfall(0.8F);

    public BiomeGenLake(int par1) {

        super(properties);

        theBiomeDecorator.treesPerChunk = 3;
        theBiomeDecorator.grassPerChunk = 12;
        theBiomeDecorator.flowersPerChunk = 0;

        this.spawnableCreatureList.clear();
    }

    public WorldGenAbstractTree genBigTreeChance(Random random) {

        return HighlandsGenerators.poplarGen;
    }
}
