package mod.baijson.simplyjuices.items.tools;

import mod.baijson.simplyjuices.SimplyJuices;

import mod.baijson.skeleton.client.render.IModelAware;
import mod.baijson.skeleton.items.tools.GenericItemTool;
import mod.baijson.skeleton.items.tools.IGenericItemTool;

import net.minecraft.util.ResourceLocation;

/**
 * Created by Baijson.
 */
public class ItemBottle extends GenericItemTool implements IGenericItemTool, IModelAware {

    /**
     * @param resource
     */
    protected ItemBottle(ResourceLocation resource) {
        super(resource);

        this.setMaxStackSize(16);
        this.setCreativeTab(SimplyJuices.SimplyJuicesTab);
    }

    /**
     * @param resource
     * @return
     */
    public static ItemBottle create(ResourceLocation resource) {
        ItemBottle self = new ItemBottle(resource);
        self.register();

        return self;
    }
}
