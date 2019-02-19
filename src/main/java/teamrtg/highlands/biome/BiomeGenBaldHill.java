package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenBaldHill extends BiomeGenBaseHighlands {

    public BiomeGenBaldHill(int par1) {

        super(HLBiomeProps.BALD_HILL.getProps());

        decorator.treesPerChunk = 0;
        decorator.grassPerChunk = 4;
        decorator.flowersPerChunk = 3;

        plants.add(HighlandsGenerators.mcBluet);
        plants.add(HighlandsGenerators.mcAllium);

    }

    public WorldGenAbstractTree genBigTreeChance(Random random) {

        return (random.nextInt(10) == 0 ? this.BIG_TREE_FEATURE : this.TREE_FEATURE);
    }

}

