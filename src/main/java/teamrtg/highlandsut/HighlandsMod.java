package teamrtg.highlandsut;

import java.io.File;

import net.minecraft.world.WorldType;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import teamrtg.highlandsut.biome.HighlandsBiomes;
import teamrtg.highlandsut.block.HighlandsBlocks;
import teamrtg.highlandsut.generator.GeneratePlants;
import teamrtg.highlandsut.generator.GenerateRiverRapids;
import teamrtg.highlandsut.generator.GenerateTrees;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MC_VERSION)
public class HighlandsMod {

    public static WorldType worldTypeHighlands;
    public static WorldType worldTypeHighlandsLB;
    HLEventManager eventMgr = new HLEventManager();
    GenerateTrees genTrees = new GenerateTrees();
    GeneratePlants genPlants = new GeneratePlants();
    GenerateRiverRapids genRRapids = new GenerateRiverRapids();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MinecraftForge.TERRAIN_GEN_BUS.register(eventMgr);
        MinecraftForge.EVENT_BUS.register(eventMgr);

        Configuration config = new Configuration(new File(event.getModConfigurationDirectory() + File.separator + "Highlands.cfg"));
        config.load();
        Config.setUpConfig(config);
        config.save();


    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        worldTypeHighlands = new WorldTypeHighlands("Highlands");
        worldTypeHighlandsLB = new WorldTypeHighlands("Highlands LB");

        GameRegistry.registerWorldGenerator(genTrees, 10);
        GameRegistry.registerWorldGenerator(genPlants, 10);
        GameRegistry.registerWorldGenerator(genRRapids, 10);

        HighlandsSettings.constructSettings();

        HighlandsBlocks.constructBlocks();

        HighlandsBiomes.constructBiomes();
        HighlandsBiomes.setUpAllSubBiomes();
        HighlandsBiomes.setUpBiomeManager();
        HighlandsBiomes.modifyVanillaBiomes();

        if (event.getSide().equals(Side.CLIENT)) {
            HighlandsBlocks.registerRenders();
        }

        HighlandsRecipes.init();

        GameRegistry.registerFuelHandler(new FuelManager());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }


}
