package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTrees;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenAdirondacksFoothills extends BiomeGenBaseHighlands {

    private int terrainInt1;
    private int terrainInt2;
    private int terrainInt3;
    private int terrainInt4;

    public BiomeGenAdirondacksFoothills(int par1) {

        super(HLBiomeProps.ADIRONDACKS_FOOTHILLS.getProps());

        theBiomeDecorator.treesPerChunk = 2;
        theBiomeDecorator.grassPerChunk = 6;
        theBiomeDecorator.flowersPerChunk = 0;

        this.terrainInt1 = 0;
        this.terrainInt2 = 1;
        this.terrainInt3 = 2;
        this.terrainInt4 = this.terrainInt1;

        plants.add(HighlandsGenerators.blueberryBush);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random) {

        return HighlandsGenerators.shrubGen;
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        for (int i = 0; i < 10; i++) {
            if (world.getTopSolidOrLiquidBlock(pos).getY() < 80) {
                int x = random.nextInt(16) + 8;
                int z = random.nextInt(16) + 8;

                BlockPos treepos = world.getHeight(pos.add(x, 0, z));

                //generate birch or fir tree
                if (random.nextInt(3) == 0) {
                    new WorldGenBigTree(false).generate(world, random, treepos);
                }
                else if (random.nextInt(5) == 0) {
                    HighlandsGenerators.firGen.generate(world, random, treepos);
                }
                else {
                    new WorldGenTrees(false, BiomeGenBaseHighlands.minTreeHeight, Blocks.LOG.getStateFromMeta(2), Blocks.LEAVES.getStateFromMeta(2), false).generate(world, random, treepos);
                }

            }
            else if (world.getTopSolidOrLiquidBlock(pos).getY() < 110) {
                int x = random.nextInt(16) + 8;
                int z = random.nextInt(16) + 8;

                BlockPos treepos = world.getHeight(pos.add(x, 0, z));

                //generate birch or fir tree
                if (random.nextInt(3) == 0) {
                    new WorldGenTaiga1().generate(world, random, treepos);
                }
                else {
                    new WorldGenTrees(false, BiomeGenBaseHighlands.minTreeHeight, Blocks.LOG.getStateFromMeta(2), Blocks.LEAVES.getStateFromMeta(2), false).generate(world, random, treepos);
                }

            }
        }

        genStandardOre(theBiomeDecorator.chunkProviderSettings.ironCount / 2, theBiomeDecorator.ironGen, theBiomeDecorator.chunkProviderSettings.ironMinHeight, theBiomeDecorator.chunkProviderSettings.ironMaxHeight, world, random, pos);

        int i = 3 + random.nextInt(6);
        int j;
        int k;
        int l;

        for (j = 0; j < i; ++j) {
            k = random.nextInt(16);
            l = random.nextInt(28) + 4;
            int i1 = random.nextInt(16);
            BlockPos blockpos1 = pos.add(k, l, i1);

            if (world.getBlockState(blockpos1).getBlock().isReplaceableOreGen(world.getBlockState(blockpos1), world, blockpos1, net.minecraft.block.state.pattern.BlockMatcher.forBlock(Blocks.STONE))) {
                world.setBlockState(blockpos1, Blocks.EMERALD_ORE.getDefaultState(), 2);
            }
        }
    }

    public void genTerrainBlocks(World worldIn, Random random, ChunkPrimer primer, int x, int z, double whatisthis) {

        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();

        if (whatisthis < 0.0D) {
            this.topBlock = Blocks.DIRT.getStateFromMeta(1);
            this.fillerBlock = Blocks.DIRT.getStateFromMeta(1);
        }
        if (whatisthis > 1.0D && this.terrainInt4 != this.terrainInt2) {
            this.topBlock = Blocks.STONE.getDefaultState();
            this.fillerBlock = Blocks.STONE.getDefaultState();
        }

        this.generateBiomeTerrain(worldIn, random, primer, x, z, whatisthis);
    }
}
