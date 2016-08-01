package teamrtg.highlands;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

import teamrtg.highlands.biome.ChunkProviderHighlands;
import teamrtg.highlands.generator.layer.GenLayerBiomeHighlands;

public class WorldTypeHighlands extends WorldType {

    public WorldTypeHighlands(String name) {

        super(name);
    }

    @Override
    public net.minecraft.world.chunk.IChunkGenerator getChunkGenerator(World world, String generatorOptions) {

        if (this == FLAT) {
            return new net.minecraft.world.gen.ChunkProviderFlat(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
        }

        if (this == DEBUG_WORLD) {
            return new net.minecraft.world.gen.ChunkProviderDebug(world);
        }

        if (this == CUSTOMIZED) {
            return new net.minecraft.world.gen.ChunkProviderOverworld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
        }

        return new ChunkProviderHighlands(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
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
     * @param chunkProviderSettingsJson The JSON string to use when initializing ChunkProviderSettings.Factory
     * @return A GenLayer that will return ints representing the Biomes to be generated, see GenLayerBiome
     */
    @Override
    public net.minecraft.world.gen.layer.GenLayer getBiomeLayer(long worldSeed, net.minecraft.world.gen.layer.GenLayer parentLayer, String chunkProviderSettingsJson) {

        GenLayer ret = new GenLayerBiomeHighlands(200L, parentLayer, this, chunkProviderSettingsJson);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
}