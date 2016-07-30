package teamrtg.highlandsut.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import teamrtg.highlandsut.References;
import teamrtg.highlandsut.generator.WorldGenPlants;

public class BlockHighlandsPlant extends BlockBush implements IGrowable{

	public boolean thornbush = false;
	
	public BlockHighlandsPlant(String name){
		super();
		setUnlocalizedName(References.MOD_ID + "_" + name);
		this.setCreativeTab(HighlandsBlocks.tabHighlands);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		new WorldGenPlants(state, 10).generate(worldIn, rand, pos);
	}

	/**
     * Called When an Entity Collided with the Block
     */
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(thornbush)
			entityIn.attackEntityFrom(DamageSource.cactus, 1);
    }

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		return super.canBlockStay(worldIn, pos, state) || state.getBlock().equals(Blocks.sand);
	}
	
	/**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block ground)
    {
        return ground == Blocks.grass || ground == Blocks.dirt || ground == Blocks.farmland || ground == Blocks.sand;
    }
	
	
}
