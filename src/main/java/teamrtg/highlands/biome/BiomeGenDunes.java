package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenDunes extends BiomeGenBaseHighlands {

    public BiomeGenDunes(int par1) {

        super(HLBiomeProps.DUNES.getProps());

        decorator.treesPerChunk = 0;
        decorator.grassPerChunk = 0;
        decorator.flowersPerChunk = 0;

        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();

        this.plants.add(HighlandsGenerators.duneGrass);
        this.plants.add(HighlandsGenerators.empty);
    }

    public WorldGenAbstractTree genBigTreeChance(Random random) {

        return HighlandsGenerators.palmGen;
    }
}
