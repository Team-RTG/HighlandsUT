package teamrtg.highlands;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.IFuelHandler;

public class FuelManager implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {

        Item i = fuel.getItem();
        Block b = Block.getBlockFromItem(i);
        if (b instanceof teamrtg.highlands.block.BlockHighlandsLog || b instanceof teamrtg.highlands.block.BlockHighlandsPlanks) {
            return 300;
        }
        if ((b instanceof teamrtg.highlands.block.BlockHighlandsSapling || b instanceof teamrtg.highlands.block.BlockHighlandsPlant)) {
            return 100;
        }
        return 0;
    }

}
