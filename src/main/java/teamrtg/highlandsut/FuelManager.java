package teamrtg.highlandsut;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.IFuelHandler;

public class FuelManager implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {

        Item i = fuel.getItem();
        Block b = Block.getBlockFromItem(i);
        if (b instanceof teamrtg.highlandsut.block.BlockHighlandsLog || b instanceof teamrtg.highlandsut.block.BlockHighlandsPlanks) {
            return 300;
        }
        if ((b instanceof teamrtg.highlandsut.block.BlockHighlandsSapling || b instanceof teamrtg.highlandsut.block.BlockHighlandsPlant)) {
            return 100;
        }
        return 0;
    }

}
