package teamrtg.highlands;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.ChunkGeneratorDebug;
import net.minecraft.world.gen.ChunkGeneratorFlat;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

import teamrtg.highlands.biome.ChunkGeneratorHighlands;
import teamrtg.highlands.generator.layer.GenLayerBiomeHighlands;

public class WorldTypeHighlands extends WorldType {

    public WorldTypeHighlands(String name) {

        super(name);
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {

        if (this == FLAT) {
            return new ChunkGeneratorFlat(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
        }

        if (this == DEBUG_ALL_BLOCK_STATES) {
            return new ChunkGeneratorDebug(world);
        }

        if (this == CUSTOMIZED) {
            return new ChunkGeneratorOverworld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
        }

        return new ChunkGeneratorHighlands(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
    }

    /**
     * Get the height to render the clouds for this world type
     *
     * @return The height to render clouds at
     */
    @Override
    public float getCloudHeight() {

        return 212.0F;
    }

    /**
     * Creates the GenLayerBiome used for generating the world with the specified ChunkProviderSettings JSON String
     * *IF AND ONLY IF* this WorldType == WorldType.CUSTOMIZED.
     *
     * @param worldSeed                 The world seed
     * @param parentLayer               The parent layer to feed into any layer you return
     * @param chunkGeneratorSettings The JSON string to use when initializing ChunkProviderSettings.Factory
     * @return A GenLayer that will return ints representing the Biomes to be generated, see GenLayerBiome
     */


    @Override
    public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkGeneratorSettings) {

        GenLayer ret = new GenLayerBiomeHighlands(200L, parentLayer, this, chunkGeneratorSettings);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
}