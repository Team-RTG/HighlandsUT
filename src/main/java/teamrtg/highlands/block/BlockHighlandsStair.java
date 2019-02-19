package teamrtg.highlands.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockHighlandsStair extends BlockStairs {
    private HighlandsBlocks.EnumTypeTree treeType;

    public BlockHighlandsStair(HighlandsBlocks.EnumTypeTree type, String treeName, Block base) {

        super(base.getDefaultState());
        setHardness(2.0F);
        setResistance(0.5F);
        setSoundType(SoundType.WOOD);
        setUnlocalizedName(treeName + "_stairs");

        this.setCreativeTab(HighlandsBlocks.tabHighlands);

        treeType = type;
    }
}
