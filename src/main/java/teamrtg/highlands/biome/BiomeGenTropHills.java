package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenTropHills extends BiomeGenBaseHighlands {

    public BiomeGenTropHills(int par1) {

        super(HLBiomeProps.TROPICAL_HILLS.getProps());

        decorator.treesPerChunk = 12;
        decorator.grassPerChunk = 10;
        decorator.flowersPerChunk = 1;

        plants.add(HighlandsGenerators.mcOrchid);
        plants.add(HighlandsGenerators.greenLeaf);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random) {

        return HighlandsGenerators.eucalyptusGen;
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        genStandardOre(decorator.chunkProviderSettings.coalCount / 2, decorator.coalGen, decorator.chunkProviderSettings.coalMinHeight, decorator.chunkProviderSettings.coalMaxHeight, world, random, pos);
    }
}
