package teamrtg.highlandsut.generator;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;

import net.minecraftforge.fml.common.IWorldGenerator;

import teamrtg.highlandsut.HighlandsSettings;
import teamrtg.highlandsut.biome.BiomeGenBaseHighlands;

public class GeneratePlants implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.getDimensionId() == 0){
			int locX = chunkX*16 + random.nextInt(16);
			int locZ = chunkZ*16 + random.nextInt(16);
			BlockPos pos = new BlockPos(locX, 1, locZ);
			BlockPos pos2 = world.getTopSolidOrLiquidBlock(pos);
			
			Biome biome = world.getBiomeGenForCoords(pos);
			
			if(biome instanceof BiomeGenBaseHighlands){
				
				
				int l = ((BiomeGenBaseHighlands) biome).plants.size();
				if(l > 0){
					((BiomeGenBaseHighlands) biome).plants.get(random.nextInt(l)).generate(world, random, pos2);
				}
			}
			
			if (HighlandsSettings.vanillaBiomeChanges){
				if(biome.equals(Biome.swampland) && random.nextInt(32) == 1){
					HighlandsGenerators.cattail.generate(world, random, pos2);
				}
				if(biome.equals(Biome.mesaPlateau_F) && random.nextInt(45) == 1){
					HighlandsGenerators.mcOTulip.generate(world, random, pos2);
				}
			
			}
		}
	}

}
