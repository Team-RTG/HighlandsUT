package teamrtg.highlands.biome;

import java.util.ArrayList;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import teamrtg.highlands.Config;
import teamrtg.highlands.HighlandsSettings;
import teamrtg.highlands.util.BiomeUtils;

/*
 * Highlands biomes - Highlands API
 * 
 * This class contains all of the biomes for Highlands.
 * Only access this class in Post Initialization!
 * The values are populated during Highlands initialization.
 */
public class HighlandsBiomes {

    //main biomes
    public static Biome highlandsBiome;
    public static Biome pinelands;
    public static Biome autumnForest;
    public static Biome alps;
    public static Biome meadow;
    public static Biome tropicDryForest;
    public static Biome redwoodForest;
    public static Biome lowlands;
    public static Biome mojave;
    public static Biome poplarHills;
    public static Biome badlands;
    public static Biome greyMtns;
    public static Biome tropHills;
    public static Biome dryForest;
    public static Biome adirondack;
    public static Biome bambooForest;
    public static Biome dunes;

    //Sub Biomes
    public static Biome lake;
    public static Biome baldHill;
    public static Biome tropicalIslands;

    //Foothill biomes.
    public static Biome adirondackFoothills;
    public static Biome alpsFoothills;
    public static Biome badlandsFoothills;
    public static Biome greyMtnsFoothills;

    //ArrayList of biomes for the Highlands worldtype
    public static ArrayList<Biome> biomesForHighlands = new ArrayList<Biome>();

    //ArrayList of Highlands biomes not including default ones, these will be added to the default world
    //Currently not used since BiomeManager doesn't really do different biomes for different world types
    //public static ArrayList<Biome> biomesForDefault = new ArrayList<Biome>();

    //ArrayList of sub-biomes, controls which Highlands biomes generate as sub-biomes (currently used for Lake and Bald Hill)
    public static ArrayList<Biome> subBiomes = new ArrayList<Biome>();

    //ArrayList of biomes that have foothills, not that are foothills.
    public static ArrayList<Biome> foothillsBiomes = new ArrayList<Biome>();

    public static void constructBiomes() {

        //main biomes

        if (Config.alpsGenerate.getBoolean(true)) {

            alps = new BiomeGenAlps(Config.alpsID.getInt());
            biomesForHighlands.add(alps);

            if (canHaveFoothills(alps)) {
                alpsFoothills = new BiomeGenAlpsFoothills(Config.alpsID.getInt() + 128);
                biomesForHighlands.add(alpsFoothills);
                foothillsBiomes.add(alps);
            }
        }
        if (Config.badlandsGenerate.getBoolean(true)) {

            badlands = new BiomeGenBadlands(Config.badlandsID.getInt());
            biomesForHighlands.add(badlands);

            if (canHaveFoothills(badlands)) {
                badlandsFoothills = new BiomeGenBadlandsFoothills(Config.badlandsID.getInt() + 128);
                biomesForHighlands.add(badlandsFoothills);
                foothillsBiomes.add(badlands);
            }
        }
        if (Config.poplarHillsGenerate.getBoolean(true)) {
            poplarHills = new BiomeGenPoplarHills(Config.poplarHillsID.getInt());
            biomesForHighlands.add(poplarHills);
        }
        if (Config.highlandsbGenerate.getBoolean(true)) {
            highlandsBiome = new BiomeGenHighlands(Config.highlandsbID.getInt());
            biomesForHighlands.add(highlandsBiome);
        }
        if (Config.lowlandsGenerate.getBoolean(true)) {
            lowlands = new BiomeGenLowlands(Config.lowlandsID.getInt());
            biomesForHighlands.add(lowlands);
        }
        if (Config.meadowGenerate.getBoolean(true)) {
            meadow = new BiomeGenMeadow(Config.meadowID.getInt());
            biomesForHighlands.add(meadow);
        }
        if (Config.pinelandsGenerate.getBoolean(true)) {
            pinelands = new BiomeGenPinelands(Config.pinelandsID.getInt());
            biomesForHighlands.add(pinelands);
        }
        if (Config.redwoodForestGenerate.getBoolean(true)) {
            redwoodForest = new BiomeGenRedwoodForest(Config.redwoodForestID.getInt());
            biomesForHighlands.add(redwoodForest);
        }
        if (Config.mojaveGenerate.getBoolean(true)) {
            mojave = new BiomeGenMojave(Config.mojaveID.getInt());
            biomesForHighlands.add(mojave);
        }
        if (Config.greyMtnsGenerate.getBoolean(true)) {

            greyMtns = new BiomeGenGreyMountains(Config.greyMtnsID.getInt());
            biomesForHighlands.add(greyMtns);

            if (canHaveFoothills(greyMtns)) {
                greyMtnsFoothills = new BiomeGenGreyMountainsFoothills(Config.greyMtnsID.getInt() + 128);
                biomesForHighlands.add(greyMtnsFoothills);
                foothillsBiomes.add(greyMtns);
            }
        }
        if (Config.tropHillsGenerate.getBoolean(true)) {
            tropHills = new BiomeGenTropHills(Config.tropHillsID.getInt());
            biomesForHighlands.add(tropHills);
        }
        if (Config.dryForestGenerate.getBoolean(true)) {
            dryForest = new BiomeGenDryForest(Config.dryForestID.getInt());
            biomesForHighlands.add(dryForest);
        }
        if (Config.adirondackGenerate.getBoolean(true)) {

            adirondack = new BiomeGenAdirondacks(Config.adirondackID.getInt());
            biomesForHighlands.add(adirondack);

            if (canHaveFoothills(adirondack)) {
                adirondackFoothills = new BiomeGenAdirondacksFoothills(Config.adirondackID.getInt() + 128);
                biomesForHighlands.add(adirondackFoothills);
                foothillsBiomes.add(adirondack);
            }
        }
        if (Config.bambooForestGenerate.getBoolean(true)) {
            bambooForest = new BiomeGenBambooForest(Config.bambooForestID.getInt());
            biomesForHighlands.add(bambooForest);
        }
        if (Config.dunesGenerate.getBoolean(true)) {
            dunes = new BiomeGenDunes(Config.dunesID.getInt());
            biomesForHighlands.add(dunes);
        }


        //sub-biomes
        if (Config.lakeGenerate.getBoolean(true)) {
            lake = new BiomeGenLake(Config.lakeID.getInt());
            subBiomes.add(lake);
        }
        if (Config.baldHillGenerate.getBoolean(true)) {
            baldHill = new BiomeGenBaldHill(Config.baldHillID.getInt());
            subBiomes.add(baldHill);
        }
        if (Config.tropicalIslandsGenerate.getBoolean(true)) {
            tropicalIslands = new BiomeGenTropicalIslands(Config.tropicalIslandsID.getInt());
            subBiomes.add(tropicalIslands);
        }
    }


    //sets up sub-biome lists after all biomes are initialized.
    public static void setUpAllSubBiomes() {

        ArrayList<Biome> enabledBiomes = new ArrayList<Biome>();
        for (Biome b : biomesForHighlands) {
            enabledBiomes.add(b);
        }
        for (Biome b : subBiomes) {
            enabledBiomes.add(b);
        }

        addSubBiome(alps, Biomes.FROZEN_RIVER, enabledBiomes);
        addSubBiome(autumnForest, baldHill, enabledBiomes);
        addSubBiome(autumnForest, lake, enabledBiomes);
        addSubBiome(poplarHills, meadow, enabledBiomes);
        addSubBiome(poplarHills, lake, enabledBiomes);
        addSubBiome(meadow, lake, enabledBiomes);
        addSubBiome(highlandsBiome, Biomes.FOREST, enabledBiomes);
        addSubBiome(pinelands, autumnForest, enabledBiomes);
        addSubBiome(redwoodForest, highlandsBiome, enabledBiomes);
        addSubBiome(redwoodForest, lake, enabledBiomes);
        addSubBiome(mojave, Biomes.MESA, enabledBiomes);
        addSubBiome(mojave, Biomes.SAVANNA, enabledBiomes);
        addSubBiome(tropHills, lake, enabledBiomes);
        addSubBiome(dryForest, Biomes.SAVANNA, enabledBiomes);
    }

    public static void addSubBiome(Biome parent, Biome sub, ArrayList<Biome> list) {

        if (parent != null && sub != null && list.contains(parent) && list.contains(sub) && parent instanceof BiomeGenBaseHighlands) {
            ((BiomeGenBaseHighlands) parent).subBiomes.add(sub);
        }
    }

    public static void setUpBiomeManager() {

        for (int i = 0; i < biomesForHighlands.size(); i++) {
            Biome hlb = biomesForHighlands.get(i);
            if (!(hlb == null)) {
                //System.out.println(hlb.biomeName + " has been added to the biome list.");

                BiomeEntry entry = new BiomeEntry(hlb, 10);
                BiomeType type = (hlb.getTemperature() < 0.3 ? BiomeType.ICY : hlb.getTemperature() < 0.5 ? BiomeType.COOL
                    : hlb.getTemperature() < 1.0 ? BiomeType.WARM : BiomeType.DESERT);
                BiomeManager.addBiome(type, entry);
                if (hlb.getTemperature() >= 0.5 && hlb.getTemperature() <= 0.7) {
                    BiomeManager.addBiome(BiomeType.COOL, entry);
                }
                if (hlb.getTemperature() >= 0.9 && hlb.getTemperature() <= 1.0) {
                    BiomeManager.addBiome(BiomeType.DESERT, entry);
                }
                BiomeManager.addSpawnBiome(hlb);
                BiomeManager.addStrongholdBiome(hlb);
                if (hlb.equals(meadow) || hlb.equals(highlandsBiome)
                    || hlb.equals(lowlands) || hlb.equals(mojave)) {
                    BiomeManager.addVillageBiome(hlb, true);
                }
            }

        }
        if (HighlandsSettings.vanillaBiomeChanges) {
            BiomeManager.addVillageBiome(Biomes.ICE_PLAINS, true);
        }

        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.DESERT, 10));
        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.SAVANNA, 10));
        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.MESA_CLEAR_ROCK, 5));
        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.MESA_ROCK, 5));
        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.MESA, 5));

        BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Biomes.JUNGLE, 10));

        BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Biomes.REDWOOD_TAIGA, 10));
    }


    public static void modifyVanillaBiomes() {

        if (HighlandsSettings.vanillaBiomeChanges) {

            /*

            TODO: How do we change the attributes of already-registered biomes? - WhichOnesPink

            Biomes.EXTREME_HILLS.minHeight = 1.0F;
            Biomes.SWAMPLAND.minHeight = -0.1F;
            Biomes.SAVANNA_PLATEAU.minHeight = 1.0F;
            Biomes.STONE_BEACH.maxHeight = 0.5F;
            Biomes.RIVER.minHeight = -0.8F;
            Biomes.RIVER.maxHeight = 0.0F;
            */
        }
    }

    public static boolean canHaveFoothills(Biome b1) {

        if (BiomeUtils.getId(b1) > 127) {
            throw new RuntimeException("Error generating foothills biome - parent ID " + BiomeUtils.getId(b1) + " is over 127.");
        }

        if (Biome.getBiome(BiomeUtils.getId(b1) + 128) != null) {
            throw new RuntimeException("Error generating foothills biome - foothills ID " + (BiomeUtils.getId(b1) + 128) + " is taken.");
        }

        return true;
    }
}







