package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenLake extends BiomeGenBaseHighlands
{

	public BiomeGenLake(int par1)
    {
		super(par1);
		
        theBiomeDecorator.treesPerChunk = 3;
        theBiomeDecorator.grassPerChunk = 12;
        theBiomeDecorator.flowersPerChunk = 0;
    	
	    this.minHeight = -0.7F;
	    this.maxHeight = 0.01F;
        this.temperature = 0.8F;
        this.rainfall = 0.8F;
	    
        this.spawnableCreatureList.clear();
    }
	
	public WorldGenAbstractTree genBigTreeChance(Random random)
    {
		return HighlandsGenerators.poplarGen;
    }
}
