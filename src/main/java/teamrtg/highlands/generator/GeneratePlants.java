package teamrtg.highlands.generator;

import java.util.Random;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

import net.minecraftforge.fml.common.IWorldGenerator;

import teamrtg.highlands.HighlandsSettings;
import teamrtg.highlands.biome.BiomeGenBaseHighlands;

public class GeneratePlants implements IWorldGenerator {

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

        if (world.provider.getDimension() == 0) {
            int locX = chunkX * 16 + random.nextInt(16);
            int locZ = chunkZ * 16 + random.nextInt(16);
            BlockPos pos = new BlockPos(locX, 1, locZ);
            BlockPos pos2 = world.getTopSolidOrLiquidBlock(pos);

            Biome biome = world.getBiome(pos);

            if (biome instanceof BiomeGenBaseHighlands) {


                int l = ((BiomeGenBaseHighlands) biome).plants.size();
                if (l > 0) {
                    ((BiomeGenBaseHighlands) biome).plants.get(random.nextInt(l)).generate(world, random, pos2);
                }
            }

            if (HighlandsSettings.vanillaBiomeChanges) {
                if (biome.equals(Biomes.SWAMPLAND) && random.nextInt(32) == 1) {
                    HighlandsGenerators.cattail.generate(world, random, pos2);
                }
                if (biome.equals(Biomes.MESA_ROCK) && random.nextInt(45) == 1) {
                    HighlandsGenerators.mcOTulip.generate(world, random, pos2);
                }

            }
        }
    }
}
