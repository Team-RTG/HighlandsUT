package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenRedwoodForest extends BiomeGenBaseHighlands {

    private int terrainInt1;
    private int terrainInt2;
    private int terrainInt3;
    private int terrainInt4;

    public BiomeGenRedwoodForest(int par1) {

        super(HLBiomeProps.REDWOOD_FOREST.getProps());

        theBiomeDecorator.treesPerChunk = 14;
        theBiomeDecorator.grassPerChunk = 5;
        theBiomeDecorator.flowersPerChunk = 0;

        this.topBlock = Blocks.DIRT.getStateFromMeta(2);

        plants.add(HighlandsGenerators.lavender);

        this.terrainInt1 = 0;
        this.terrainInt2 = 1;
        this.terrainInt3 = 2;
        this.terrainInt4 = this.terrainInt1;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random) {

        if (par1Random.nextInt(3) == 0) {
            return HighlandsGenerators.redwoodGen;
        }
        else if (par1Random.nextInt(2) == 0) {
            return HighlandsGenerators.firGen;
        }
        else {
            return HighlandsGenerators.shrub2Gen;
        }
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        genStandardOre(theBiomeDecorator.chunkProviderSettings.redstoneCount / 2, theBiomeDecorator.redstoneGen, theBiomeDecorator.chunkProviderSettings.redstoneMinHeight, theBiomeDecorator.chunkProviderSettings.redstoneMaxHeight, world, random, pos);
    }


    public void genTerrainBlocks(World worldIn, Random random, ChunkPrimer primer, int x, int z, double whatisthis) {

        this.topBlock = Blocks.DIRT.getStateFromMeta(2);
        this.fillerBlock = Blocks.DIRT.getDefaultState();

        if (whatisthis > 1.0D && this.terrainInt4 != this.terrainInt2) {
            this.topBlock = Blocks.GRASS.getDefaultState();
        }

        this.generateBiomeTerrain(worldIn, random, primer, x, z, whatisthis);
    }
}
