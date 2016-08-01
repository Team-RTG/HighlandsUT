package teamrtg.highlands.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockHighlandsPlanks extends Block {

    private HighlandsBlocks.EnumTypeTree treeType;

    public BlockHighlandsPlanks(HighlandsBlocks.EnumTypeTree type, String treeName) {

        super(Material.WOOD);
        setHardness(2.0F);
        setResistance(0.5F);
        setSoundType(SoundType.WOOD);
        setUnlocalizedName(treeName + "_planks");

        this.setCreativeTab(HighlandsBlocks.tabHighlands);

        treeType = type;
    }
}