package mod.baijson.simplyjuices.items.tools;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.skeleton.client.render.IModelAware;
import mod.baijson.skeleton.items.tools.GenericItemTool;
import mod.baijson.skeleton.items.tools.IGenericItemTool;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Baijson.
 */
public class ItemJuicer extends GenericItemTool implements IGenericItemTool, IModelAware {

    /**
     * @param resource
     */
    protected ItemJuicer(ResourceLocation resource) {
        super(resource);

        this.setCreativeTab(SimplyJuices.SimplyJuicesTab);
    }

    /**
     * @param resource
     * @return
     */
    public static ItemJuicer create(ResourceLocation resource) {
        ItemJuicer self = new ItemJuicer(resource);
        self.register();

        return self;
    }
}
