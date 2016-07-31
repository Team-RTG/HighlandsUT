package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenDunes extends BiomeGenBaseHighlands {

    private static BiomeProperties properties = new Biome.BiomeProperties("Dunes")
        .setBaseHeight(-0.15F)
        .setHeightVariation(0.5F)
        .setTemperature(0.95F)
        .setRainfall(0.4F);

    public BiomeGenDunes(int par1) {

        super(properties);

        theBiomeDecorator.treesPerChunk = 0;
        theBiomeDecorator.grassPerChunk = 0;
        theBiomeDecorator.flowersPerChunk = 0;

        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();

        this.plants.add(HighlandsGenerators.duneGrass);
        this.plants.add(HighlandsGenerators.empty);
    }

    public WorldGenAbstractTree genBigTreeChance(Random random) {

        return HighlandsGenerators.palmGen;
    }
}
