package teamrtg.highlands.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import teamrtg.highlands.reference.ModInfo;

public class HighlandsBlocks {

    public static final int NUM_TREE_TYPES = 7;
    public static final int NUM_PLANTS = 9;

    public static final CreativeTabs tabHighlands = new CreativeTabs(ModInfo.MOD_ID){
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.SAPLING);
        }
    };

    //tree blocks
    public static Block[] planks;
    public static Block[] woods;
    public static Block[] leaves;
    public static Block[] saplings;

    //wood products
    public static Block[] doors;
    public static Block[] fences;
    public static Block[] slabs;
    public static Block[] doubleSlabs;
    public static Block[] stairs;

    //plants
    public static Block[] plants;

    public static void registerBlocks(RegistryEvent.Register<Block> event){
        EnumTypeTree.ASPEN.setMetaLookup();
        EnumTypeTree.POPLAR.setMetaLookup();
        EnumTypeTree.EUCA.setMetaLookup();
        EnumTypeTree.PALM.setMetaLookup();
        EnumTypeTree.FIR.setMetaLookup();
        EnumTypeTree.REDWOOD.setMetaLookup();
        EnumTypeTree.BAMBOO.setMetaLookup();

        EnumTypePlant.BLUEFLOWER.setMetaLookup();
        EnumTypePlant.CATTAIL.setMetaLookup();
        EnumTypePlant.COTTON.setMetaLookup();
        EnumTypePlant.BLUEBERRYBUSH.setMetaLookup();
        EnumTypePlant.RASPBERRYBUSH.setMetaLookup();
        EnumTypePlant.THORNBUSH.setMetaLookup();
        EnumTypePlant.LAVENDER.setMetaLookup();
        EnumTypePlant.GREENLEAF.setMetaLookup();
        EnumTypePlant.DUNEGRASS.setMetaLookup();

        //initialize arrays
        planks = new Block[NUM_TREE_TYPES];
        woods = new Block[NUM_TREE_TYPES];
        leaves = new Block[NUM_TREE_TYPES];
        saplings = new Block[NUM_TREE_TYPES];
        doors = new Block[NUM_TREE_TYPES];
        fences = new Block[NUM_TREE_TYPES];
        slabs = new Block[NUM_TREE_TYPES];
        doubleSlabs = new Block[NUM_TREE_TYPES];
        stairs = new Block[NUM_TREE_TYPES];

        plants = new Block[NUM_PLANTS];

        //initialize blocks within arrays
        for (int i = 0; i < NUM_TREE_TYPES; i++) {
            planks[i] = new BlockHighlandsPlanks(EnumTypeTree.META_LOOKUP[i], ModInfo.MOD_ID + "_" + EnumTypeTree.META_LOOKUP[i].getName());
            woods[i] = new BlockHighlandsLog(EnumTypeTree.META_LOOKUP[i], ModInfo.MOD_ID + "_" + EnumTypeTree.META_LOOKUP[i].getName());
            leaves[i] = new BlockHighlandsLeaves(EnumTypeTree.META_LOOKUP[i], ModInfo.MOD_ID + "_" + EnumTypeTree.META_LOOKUP[i].getName());
            saplings[i] = new BlockHighlandsSapling(EnumTypeTree.META_LOOKUP[i], ModInfo.MOD_ID + "_" + EnumTypeTree.META_LOOKUP[i].getName());
            stairs[i] = new BlockHighlandsStair(EnumTypeTree.META_LOOKUP[i], ModInfo.MOD_ID + "_" + EnumTypeTree.META_LOOKUP[i].getName(), planks[i]);


            event.getRegistry().register(planks[i]);
            event.getRegistry().register(stairs[i]);
            event.getRegistry().register(woods[i]);
            event.getRegistry().register(leaves[i]);
            event.getRegistry().register(saplings[i]);

            OreDictionary.registerOre("logWood", woods[i]);
            OreDictionary.registerOre("plankWood", planks[i]);
            OreDictionary.registerOre("treeLeaves", leaves[i]);
            OreDictionary.registerOre("treeSapling", saplings[i]);

            Blocks.FIRE.setFireInfo(leaves[i], 30, 60);
            Blocks.FIRE.setFireInfo(planks[i], 5, 20);
            Blocks.FIRE.setFireInfo(woods[i], 5, 5);
        }

        for (int i = 0; i < NUM_PLANTS; i++) {
            plants[i] = new BlockHighlandsPlant(EnumTypePlant.META_LOOKUP[i].name);

            event.getRegistry().register(plants[i]);

            Blocks.FIRE.setFireInfo(plants[i], 60, 100);
        }
        ((BlockHighlandsPlant) plants[EnumTypePlant.THORNBUSH.meta]).thornbush = true;
    }

    public static void constructBlocks() {
        //initialize EnumType meta lookup

    }

    public static void registerRenders() {

        for (int i = 0; i < NUM_TREE_TYPES; i++) {
            registerRender(planks[i]);
            registerRender(woods[i]);
            registerRender(leaves[i]);
            registerRender(saplings[i]);
        }

        for (int i = 0; i < NUM_PLANTS; i++) {
            registerRender(plants[i]);
        }
    }

    private static void registerRender(Block block) {

        Item item = Item.getItemFromBlock(block);

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
            new ModelResourceLocation(ModInfo.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "inventory"));
        /*
        if(block instanceof BlockHighlandsLeaves){
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "check_decay=false,decayable=false"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "check_decay=true,decayable=false"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "check_decay=false,decayable=true"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "check_decay=true,decayable=true"));
		}
		if(block instanceof BlockHighlandsSapling){
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "stage=0"));
		}
		*/
    }


    public static enum EnumTypeTree implements IStringSerializable {
        ASPEN(0, "aspen"),
        POPLAR(1, "poplar"),
        EUCA(2, "eucalyptus"),
        PALM(3, "palm"),
        FIR(4, "fir"),
        REDWOOD(5, "redwood"),
        BAMBOO(6, "bamboo");
        private static final EnumTypeTree[] META_LOOKUP = new EnumTypeTree[values().length];
        private final int meta;
        private final String name;

        private EnumTypeTree(int meta, String name) {

            this.meta = meta;
            this.name = name;
        }

        public void setMetaLookup() {

            EnumTypeTree.META_LOOKUP[this.meta] = this;
        }

        public int getMetadata() {

            return this.meta;
        }

        public String toString() {

            return this.name;
        }

        public String getName() {

            return this.name;
        }
    }

    public static enum EnumTypePlant implements IStringSerializable {
        BLUEFLOWER(0, "blue_flower"),
        CATTAIL(1, "cattail"),
        COTTON(2, "cotton"),
        RASPBERRYBUSH(3, "raspberry_bush"),
        BLUEBERRYBUSH(4, "blueberry_bush"),
        THORNBUSH(5, "thorn_bush"),
        LAVENDER(6, "lavender"),
        GREENLEAF(7, "green_leaf"),
        DUNEGRASS(8, "dune_grass");
        private static final EnumTypePlant[] META_LOOKUP = new EnumTypePlant[values().length];
        private final int meta;
        private final String name;

        private EnumTypePlant(int meta, String name) {

            this.meta = meta;
            this.name = name;
        }

        public void setMetaLookup() {

            EnumTypePlant.META_LOOKUP[this.meta] = this;
        }

        public int getMetadata() {

            return this.meta;
        }

        public String toString() {

            return this.name;
        }

        public String getName() {

            return this.name;
        }
    }
}
