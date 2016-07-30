package teamrtg.highlandsut.generator;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

import net.minecraftforge.fml.common.IWorldGenerator;

public class GenerateRiverRapids implements IWorldGenerator
{
	
	public static final int SEA_LEVEL = 64;

	/**
	 * Generate some world
	 *
	 * @param random         the chunk specific {@link Random}.
	 * @param chunkX         the chunk X coordinate of this chunk.
	 * @param chunkZ         the chunk Z coordinate of this chunk.
	 * @param world          : additionalData[0] The minecraft {@link World} we're generating for.
	 * @param chunkGenerator : additionalData[1] The {@link IChunkProvider} that is generating.
	 * @param chunkProvider  : additionalData[2] {@link IChunkProvider} that is requesting the world generation.
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		/*

		*******************************************************************************************
		* The entire body of this method was already commented out when I got here. - WhichOnesPink
		*******************************************************************************************


		if(world.provider.getDimensionId() == 0){


			for(int i = 0; i < 16; i++){
				for(int k = 0; k < 16; k++){
					int locX = chunkX*16 + i;
					int locZ = chunkZ*16 + k;

					BlockPos pos = new BlockPos(locX, 1, locZ);
					Biome biome = world.getBiomeGenForCoords(pos);

					if(biome.equals(Biome.river)){
						BlockPos pos2 = world.getTopSolidOrLiquidBlock(pos);

						Biome biome2 = world.getBiomeGenForCoords(pos2.north(8));
						if(biome2.equals(Biome.river))  biome2 = world.getBiomeGenForCoords(pos2.east(8));
						Biome biome3 = world.getBiomeGenForCoords(pos2.south(8));
						if(biome3.equals(Biome.river))  biome3 = world.getBiomeGenForCoords(pos2.west(8));

						int y = getNewSeaLevel(biome2, biome3);
						for(int j = 0; j < y-pos2.getY(); j++){
							world.setBlockState(pos2.up(j), Blocks.water.getDefaultState());
							Blocks.water.updateTick(world, pos2.up(j), Blocks.water.getDefaultState(), random);
						}

					}
				}
			}
		}
		*/
	}
	
	public int getNewSeaLevel(Biome b1, Biome b2){
		double b1average = b1.minHeight+ b1.maxHeight/2;
		double b2average = b2.minHeight+ b2.maxHeight/2;
		
		if(b2average + b1average > 2)	
			return (int)(SEA_LEVEL + b1average + b2average);
		else return SEA_LEVEL;
	}
}
