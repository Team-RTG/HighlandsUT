package teamrtg.highlandsut.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;

import teamrtg.highlandsut.HighlandsSettings;
import teamrtg.highlandsut.generator.WorldGenPlants;

public abstract class BiomeGenBaseHighlands extends Biome {

    public static int minTreeHeight = 4;
    public ArrayList<Biome> subBiomes;
    public ArrayList<WorldGenPlants> plants;
    public int plantsPerChunk;

    public Biome.BiomeProperties biomeProps;

    public BiomeGenBaseHighlands(Biome.BiomeProperties properties) {

        super(properties);
        subBiomes = new ArrayList<Biome>();
        plants = new ArrayList<WorldGenPlants>();
        plantsPerChunk = 0;
    }

    public void setSpawnLists(List monster, List creature, List waterCreature) {

        this.spawnableCreatureList = creature;
        this.spawnableMonsterList = monster;
        this.spawnableWaterCreatureList = waterCreature;
    }

    /**
     * because BiomeDecorator won't let me see it...
     *
     * @param blobsPerChunk
     * @param oreGenerator
     * @param minHeight
     * @param maxHeight
     */
    protected void genStandardOre(int blobsPerChunk, WorldGenerator oreGenerator, int minHeight, int maxHeight, World world, Random rng, BlockPos pos) {

        if (!HighlandsSettings.useOreGens) {
            return;
        }
        int l;

        if (maxHeight < minHeight) {
            l = minHeight;
            minHeight = maxHeight;
            maxHeight = l;
        }
        else if (maxHeight == minHeight) {
            if (minHeight < 255) {
                ++maxHeight;
            }
            else {
                --minHeight;
            }
        }

        for (l = 0; l < blobsPerChunk; ++l) {
            BlockPos blockpos = pos.add(rng.nextInt(16), rng.nextInt(maxHeight - minHeight) + minHeight, rng.nextInt(16));
            oreGenerator.generate(world, rng, blockpos);
        }
    }

    /**
     * Adds a creature to spawn in a certain biome.  Not compatible with DrZhark's CustomMobSpawner.
     *
     * @param creature the creature to add
     */
    public void addCreature(EntityCreature creature) {

        List creatureList = this.getSpawnableList(EnumCreatureType.CREATURE);
        creatureList.add(creature);
        this.setSpawnLists(
            this.getSpawnableList(EnumCreatureType.MONSTER),
            creatureList,
            this.getSpawnableList(EnumCreatureType.WATER_CREATURE)
        );
    }

    public void addMob(EntityMob mob) {

        List mobList = this.getSpawnableList(EnumCreatureType.MONSTER);
        mobList.add(mob);
        this.setSpawnLists(
            mobList,
            this.getSpawnableList(EnumCreatureType.CREATURE),
            this.getSpawnableList(EnumCreatureType.WATER_CREATURE)
        );
    }

    public void addWaterCreature(EntityCreature creature) {

        List waterCreatureList = this.getSpawnableList(EnumCreatureType.WATER_CREATURE);
        waterCreatureList.add(creature);
        this.setSpawnLists(
            this.getSpawnableList(EnumCreatureType.MONSTER),
            this.getSpawnableList(EnumCreatureType.CREATURE),
            waterCreatureList
        );
    }

    public static enum HLBiomeProps {

        ADIRONDACKS ("Adirondacks", 0.8F, 0.8F, 0.5F, 0.6F, false),
        ADIRONDACKS_FOOTHILLS ("Adirondacks Foothills", 0.8F, 0.8F, 0.5F, 0.6F, false),
        ALPS ("Alps", 1.5F, 1.0F, 0.0F, 0.7F, true),
        ALPS_FOOTHILLS ("Alps Foothills", 1.5F, 1.0F, 0.0F, 0.7F, true),
        BADLANDS ("Badlands", 0.8F, 0.6F, 0.6F, 0.1F, false),
        BADLANDS_FOOTHILLS ("Badlands Foothills", 0.8F, 0.6F, 0.6F, 0.1F, false),
        BALD_HILL ("Bald Hill", 1.5F, 0.4F, 0.5F, 0.7F, false),
        BAMBOO_FOREST ("Bamboo Forest", 0.3F, 0.2F, 1.1F, 0.3F, false),
        DRY_FOREST ("Dry Forest", 0.3F, 0.2F, 1.1F, 0.3F, false),
        DUNES ("Dunes", -0.15F, 0.5F, 0.95F, 0.4F, false),
        GREY_MOUNTAINS ("Grey Mountains", 1.8F, 1.0F, 0.6F, 0.1F, false),
        GREY_MOUNTAINS_FOOTHILLS ("Grey Mountains Foothills", 1.8F, 1.0F, 0.6F, 0.1F, false),
        HIGHLANDS ("Highlands", 0.7F, 0.4F, 0.6F, 0.2F, false),
        LAKE ("Lake", -0.7F, 0.01F, 0.8F, 0.8F, false),
        LOWLANDS ("Lowlands", -0.1F, 0.2F, 0.5F, 1.2F, false),
        MEADOW ("Meadow", 0.15F, 0.15F, 0.7F, 0.8F, false),
        MOJAVE ("Mojave", 0.2F, 0.4F, 1.6F, 0.1F, false),
        PINELANDS ("Pinelands", 0.4F, 0.6F, 0.5F, 0.6F, false),
        POPLAR_HILLS ("Poplar Hills", -0.1F, 0.4F, 0.6F, 0.8F, false),
        REDWOOD_FOREST ("Redwood Forest", 0.5F, 0.2F, 0.6F, 0.2F, false),
        TROPICAL_HILLS ("Tropical Hills", 0.4F, 0.5F, 0.95F, 0.7F, false),
        TROPICAL_ISLANDS ("Tropical Islands", -0.2F, 0.2F, 0.95F, 1.2F, false);

        private final String biomeName;
        private final float baseHeight;
        private final float heightVariation;
        private final float temperature;
        private final float rainfall;
        private final boolean snowEnabled;
        private final Biome.BiomeProperties props;

        HLBiomeProps(String biomeName, float baseHeight, float heightVariation, float temperature, float rainfall, boolean snowEnabled) {

            this.biomeName = biomeName;
            this.baseHeight = baseHeight;
            this.heightVariation = heightVariation;
            this.temperature = temperature;
            this.rainfall = rainfall;
            this.snowEnabled = snowEnabled;

            this.props = new Biome.BiomeProperties(this.biomeName)
                .setBaseHeight(this.baseHeight)
                .setHeightVariation(this.heightVariation)
                .setTemperature(this.temperature);

            if (this.snowEnabled) {
                this.props.setSnowEnabled();
            }
        }

        public String getBiomeName() { return this.biomeName; }
        public float getBaseHeight() { return this.baseHeight; }
        public float getHeightVariation() { return this.heightVariation; }
        public float getTemperature() { return this.temperature; }
        public float getRainfall() { return this.rainfall; }
        public boolean getSnowEnabled() { return this.snowEnabled; }

        public Biome.BiomeProperties getProps() { return this.props; }
    }
}
