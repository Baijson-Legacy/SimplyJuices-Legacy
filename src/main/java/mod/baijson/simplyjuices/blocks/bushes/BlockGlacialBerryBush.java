package mod.baijson.simplyjuices.blocks.bushes;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Baijson.
 */
public class BlockGlacialBerryBush extends BlockGenericBerryBush {

    /**
     * @param resource
     * @param material
     */
    protected BlockGlacialBerryBush(ResourceLocation resource, Item material) {
        super(resource, material);
    }

    /**
     * @param resource
     * @param material
     * @return
     */
    public static BlockGlacialBerryBush create(ResourceLocation resource, Item material) {
        BlockGlacialBerryBush self = new BlockGlacialBerryBush(resource, material);
        self.register();

        return self;
    }
}
