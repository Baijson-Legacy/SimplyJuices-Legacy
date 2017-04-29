package mod.baijson.simplyjuices.client;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.simplyjuices.blocks.BlockRegistry;
import mod.baijson.simplyjuices.common.CommonProxy;
import mod.baijson.simplyjuices.items.ItemsRegistry;
import mod.baijson.skeleton.client.CreativeTab;
import mod.baijson.skeleton.client.render.LazyColorHandler;
import mod.baijson.skeleton.client.render.LazyModelHandler;
import mod.baijson.skeleton.common.ISidedProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Baijson.
 */
public class ClientProxy extends CommonProxy implements ISidedProxy {

    /**
     * @param event
     */
    @Override
    public void init(FMLPreInitializationEvent event) {
        super.init(event);

        LazyModelHandler.load(BlockRegistry.class);
        LazyModelHandler.load(ItemsRegistry.class);
    }

    /**
     * @param event
     */
    @Override
    public void load(FMLInitializationEvent event) {
        super.load(event);

        LazyColorHandler.load(ItemsRegistry.class);
        LazyColorHandler.load(BlockRegistry.class);

        SimplyJuices.SimplyJuicesTab.setTabIconItem(new ItemStack(ItemsRegistry.itemJuiceSnozzberry));
    }

    /**
     * @param event
     */
    @Override
    public void post(FMLPostInitializationEvent event) {
        super.post(event);
    }
}
