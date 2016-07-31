package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenBaldHill extends BiomeGenBaseHighlands {

    private static BiomeProperties properties = new Biome.BiomeProperties("Bald Hill")
        .setBaseHeight(1.5F)
        .setHeightVariation(0.4F)
        .setTemperature(0.5F)
        .setRainfall(0.7F);

    public BiomeGenBaldHill(int par1) {

        super(properties);

        theBiomeDecorator.treesPerChunk = 0;
        theBiomeDecorator.grassPerChunk = 4;
        theBiomeDecorator.flowersPerChunk = 3;

        plants.add(HighlandsGenerators.mcBluet);
        plants.add(HighlandsGenerators.mcAllium);

    }

    public WorldGenAbstractTree genBigTreeChance(Random random) {

        return (random.nextInt(10) == 0 ? this.BIG_TREE_FEATURE : this.TREE_FEATURE);
    }

}

