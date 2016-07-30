package teamrtg.highlandsut.biome;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import net.minecraft.world.biome.Biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import teamrtg.highlandsut.Config;
import teamrtg.highlandsut.HighlandsSettings;

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
    
    
    //ArrayList of biomes for the Highlands worldtype
    public static ArrayList<Biome> biomesForHighlands = new ArrayList<Biome>();
    
    //ArrayList of Highlands biomes not including default ones, these will be added to the default world
    //Currently not used since BiomeManager doesn't really do different biomes for different world types
    //public static ArrayList<Biome> biomesForDefault = new ArrayList<Biome>();
    
    //ArrayList of sub-biomes, controls which Highlands biomes generate as sub-biomes (currently used for Lake and Bald Hill)
    public static ArrayList<Biome> subBiomes = new ArrayList<Biome>();
    
    //ArrayList of biomes that have foothills, not that are foothills.
    public static ArrayList<Biome> foothillsBiomes = new ArrayList<Biome>();
    
    
private static String biomePrefix = "";
	
	public static void constructBiomes()
	{
		
		biomePrefix = Config.biomePrefix.getBoolean(false) ? "Highlands_" : "";
		
		//main biomes
		
		if(Config.alpsGenerate.getBoolean(true))
		{
			alps = new BiomeGenAlps(Config.alpsID.getInt()).setBiomeName(biomePrefix+"Alps");
			biomesForHighlands.add(alps);
			createFoothills(alps);
		}
		if(Config.badlandsGenerate.getBoolean(true))
		{
			badlands = new BiomeGenBadlands(Config.badlandsID.getInt()).setBiomeName(biomePrefix+"Badlands");
			biomesForHighlands.add(badlands);
			createFoothills(badlands);
		}
		if(Config.poplarHillsGenerate.getBoolean(true))
		{
			poplarHills = new BiomeGenPoplarHills(Config.poplarHillsID.getInt()).setBiomeName(biomePrefix+"Poplar Hills");
			biomesForHighlands.add(poplarHills);
		}
		if(Config.highlandsbGenerate.getBoolean(true))
		{
			highlandsBiome = new BiomeGenHighlands(Config.highlandsbID.getInt()).setBiomeName(biomePrefix+"Highlands");
			biomesForHighlands.add(highlandsBiome);
		}
		if(Config.lowlandsGenerate.getBoolean(true))
		{
			lowlands = new BiomeGenLowlands(Config.lowlandsID.getInt()).setBiomeName(biomePrefix+"Lowlands");
			biomesForHighlands.add(lowlands);
		}
		if(Config.meadowGenerate.getBoolean(true))
		{
			meadow = new BiomeGenMeadow(Config.meadowID.getInt()).setBiomeName(biomePrefix+"Meadow");
			biomesForHighlands.add(meadow);
		}
		if(Config.pinelandsGenerate.getBoolean(true))
		{
			pinelands = new BiomeGenPinelands(Config.pinelandsID.getInt()).setBiomeName(biomePrefix+"Pinelands");
			biomesForHighlands.add(pinelands);
		}
		if(Config.redwoodForestGenerate.getBoolean(true))
		{
			redwoodForest = new BiomeGenRedwoodForest(Config.redwoodForestID.getInt()).setBiomeName(biomePrefix+"Redwood Forest");
			biomesForHighlands.add(redwoodForest);
		}
		if(Config.mojaveGenerate.getBoolean(true))
		{
			mojave = new BiomeGenMojave(Config.mojaveID.getInt()).setBiomeName(biomePrefix+"Mojave");
			biomesForHighlands.add(mojave);
		}
		if(Config.greyMtnsGenerate.getBoolean(true))
		{
			greyMtns = new BiomeGenGreyMountains(Config.greyMtnsID.getInt()).setBiomeName(biomePrefix+"Grey Mountains");
			biomesForHighlands.add(greyMtns);
			createFoothills(greyMtns);
		}
		if(Config.tropHillsGenerate.getBoolean(true))
		{
			tropHills = new BiomeGenTropHills(Config.tropHillsID.getInt()).setBiomeName(biomePrefix+"Tropical Hills");
			biomesForHighlands.add(tropHills);
		}
		if(Config.dryForestGenerate.getBoolean(true))
		{
			dryForest = new BiomeGenDryForest(Config.dryForestID.getInt()).setBiomeName(biomePrefix+"Dry Forest");
			biomesForHighlands.add(dryForest);
		}
		if(Config.adirondackGenerate.getBoolean(true))
		{
			adirondack = new BiomeGenAdirondacks(Config.adirondackID.getInt()).setBiomeName(biomePrefix+"Adirondacks");
			biomesForHighlands.add(adirondack);
			createFoothills(adirondack);
		}
		if(Config.bambooForestGenerate.getBoolean(true))
		{
			bambooForest = new BiomeGenBambooForest(Config.bambooForestID.getInt()).setBiomeName(biomePrefix+"Bamboo Forest");
			biomesForHighlands.add(bambooForest);
		}
		if(Config.dunesGenerate.getBoolean(true))
		{
			dunes = new BiomeGenDunes(Config.dunesID.getInt()).setBiomeName(biomePrefix+"Dunes");
			biomesForHighlands.add(dunes);
		}
		
		
		//sub-biomes
		if(Config.lakeGenerate.getBoolean(true))
		{
			lake = new BiomeGenLake(Config.lakeID.getInt()).setBiomeName(biomePrefix+"Lake");
			subBiomes.add(lake);
		}
		if(Config.baldHillGenerate.getBoolean(true))
		{
			baldHill = new BiomeGenBaldHill(Config.baldHillID.getInt()).setBiomeName(biomePrefix+"Bald Hill");
			subBiomes.add(baldHill);
		}
		if(Config.tropicalIslandsGenerate.getBoolean(true))
		{
			tropicalIslands = new BiomeGenTropicalIslands(Config.tropicalIslandsID.getInt()).setBiomeName(biomePrefix+"Tropical Islands");
			subBiomes.add(tropicalIslands);
		}
	}
	
	
	//sets up sub-biome lists after all biomes are initialized.
	public static void setUpAllSubBiomes()
	{
		ArrayList<Biome> enabledBiomes = new ArrayList<Biome>();
		for(Biome b : biomesForHighlands)enabledBiomes.add(b);
		for(Biome b : subBiomes)enabledBiomes.add(b);
		
		addSubBiome(alps, Biome.frozenRiver, enabledBiomes);
		addSubBiome(autumnForest, baldHill, enabledBiomes);
		addSubBiome(autumnForest, lake, enabledBiomes);
		addSubBiome(poplarHills, meadow, enabledBiomes);
		addSubBiome(poplarHills, lake, enabledBiomes);
		addSubBiome(meadow, lake, enabledBiomes);
		addSubBiome(highlandsBiome, Biome.forest, enabledBiomes);
		addSubBiome(pinelands, autumnForest, enabledBiomes);
		addSubBiome(redwoodForest, highlandsBiome, enabledBiomes);
		addSubBiome(redwoodForest, lake, enabledBiomes);
		addSubBiome(mojave, Biome.mesa, enabledBiomes);
		addSubBiome(mojave, Biome.savanna, enabledBiomes);
		addSubBiome(tropHills, lake, enabledBiomes);
		addSubBiome(dryForest, Biome.savanna, enabledBiomes);
	}
	
	public static void addSubBiome(Biome parent, Biome sub, ArrayList<Biome> list)
	{
		if(parent != null && sub != null && list.contains(parent) && list.contains(sub) && parent instanceof BiomeGenBaseHighlands){
			((BiomeGenBaseHighlands)parent).subBiomes.add(sub);
		}
	}
	
	public static void setUpBiomeManager()
	{
		for(int i = 0; i < biomesForHighlands.size(); i++)
		{
			Biome hlb = biomesForHighlands.get(i);
			if(!(hlb == null))
			{
				//System.out.println(hlb.biomeName + " has been added to the biome list.");
				
				BiomeEntry entry = new BiomeEntry(hlb, 10);
				BiomeType type = (hlb.temperature < 0.3 ? BiomeType.ICY : hlb.temperature < 0.5 ? BiomeType.COOL
						: hlb.temperature < 1.0 ? BiomeType.WARM : BiomeType.DESERT);
				BiomeManager.addBiome(type, entry);
				if(hlb.temperature >= 0.5 && hlb.temperature <= 0.7)
					BiomeManager.addBiome(BiomeType.COOL, entry);
				if(hlb.temperature >= 0.9 && hlb.temperature <= 1.0)
					BiomeManager.addBiome(BiomeType.DESERT, entry);
				BiomeManager.addSpawnBiome(hlb);
				BiomeManager.addStrongholdBiome(hlb);
				if(hlb.equals(meadow) || hlb.equals(highlandsBiome)
						|| hlb.equals(lowlands) || hlb.equals(mojave))
					BiomeManager.addVillageBiome(hlb, true);
			}
			
		}
		if(HighlandsSettings.vanillaBiomeChanges)
			BiomeManager.addVillageBiome(Biome.icePlains, true);
		
		BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biome.desert, 10));
		BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biome.savanna, 10));
		BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biome.mesaPlateau, 5));
		BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biome.mesaPlateau_F, 5));
		BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biome.mesa, 5));
		
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Biome.jungle, 10));
		
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Biome.megaTaiga, 10));
	}
	
	
	public static void modifyVanillaBiomes(){
		
		if(HighlandsSettings.vanillaBiomeChanges){
		
			Biome.extremeHills.minHeight = 1.0F;
			Biome.swampland.minHeight = -0.1F;
			Biome.savannaPlateau.minHeight = 1.0F;
			Biome.stoneBeach.maxHeight = 0.5F;
			Biome.river.minHeight = -0.8F;
			Biome.river.maxHeight = 0.0F;
		}
	}
    
	/**
	 * Creates a foothills biome, which has half the height of its parent mountain biome.
	 * @param b1 the mountain biome to create foothills for
	 * @return
	 */
	public static Biome createFoothills(Biome b1){
		Class<? extends Biome> biomeClass = b1.getBiomeClass();
		if(Biome.getIdForBiome(b1) > 127){
			System.out.println("Error generating foothills biome- parent ID " + Biome.getIdForBiome(b1) + " is over 127.");
			return null;
		}
		else if(Biome.getBiome(Biome.getIdForBiome(b1) + 128) != null){
			System.out.println("Error generating foothills biome- foothills ID " + (Biome.getIdForBiome(b1)+128) + " is taken.");
			return null;
		}
		Biome fh = null;
		try{
			Constructor<?> biomeCons = biomeClass.getConstructor(int.class);
			fh = (Biome) biomeCons.newInstance(Biome.getIdForBiome(b1) + 128);
			fh.maxHeight = b1.maxHeight /2;
			fh.minHeight = b1.minHeight /2;
			fh.setBiomeName(b1.getBiomeName() + " foothills");
			foothillsBiomes.add(b1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return fh;
	}
}







