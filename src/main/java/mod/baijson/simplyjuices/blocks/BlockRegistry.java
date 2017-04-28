package mod.baijson.simplyjuices.blocks;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.simplyjuices.blocks.bushes.BlockGenericBerryBush;
import mod.baijson.simplyjuices.items.ItemsRegistry;
import mod.baijson.skeleton.client.render.IMarkedLazy;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Baijson.
 */
public class BlockRegistry implements IMarkedLazy {

    static public BlockGenericBerryBush blockBushBlackberry;
    static public BlockGenericBerryBush blockBushCloudberry;
    static public BlockGenericBerryBush blockBushGooseberry;
    static public BlockGenericBerryBush blockBushSnozzberry;
    static public BlockGenericBerryBush blockBushStrawberry;

    //static public BlockGenericBerryBush blockBushCloudberry;
    //static public BlockGenericBerryBush blockBushCloudberry;

    /**
     * Load and register objects.
     */
    static public void load() {

        blockBushBlackberry = BlockGenericBerryBush.create(new ResourceLocation(SimplyJuices.MODID, "blockbushblackberry"), ItemsRegistry.itemBerryBlackberry);
        blockBushCloudberry = BlockGenericBerryBush.create(new ResourceLocation(SimplyJuices.MODID, "blockbushcloudberry"), ItemsRegistry.itemBerryCloudberry);
        blockBushGooseberry = BlockGenericBerryBush.create(new ResourceLocation(SimplyJuices.MODID, "blockbushgooseberry"), ItemsRegistry.itemBerryGooseberry);
        blockBushSnozzberry = BlockGenericBerryBush.create(new ResourceLocation(SimplyJuices.MODID, "blockbushsnozzberry"), ItemsRegistry.itemBerrySnozzberry);
        blockBushStrawberry = BlockGenericBerryBush.create(new ResourceLocation(SimplyJuices.MODID, "blockbushstrawberry"), ItemsRegistry.itemBerryStrawberry);

    }
}
