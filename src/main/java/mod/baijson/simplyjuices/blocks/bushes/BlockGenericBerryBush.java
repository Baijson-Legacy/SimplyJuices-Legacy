package mod.baijson.simplyjuices.blocks.bushes;

import mod.baijson.simplyjuices.SimplyJuices;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Baijson.
 */
public class BlockGenericBerryBush extends BlockBerryBush {

    /**
     * @param resource
     * @param material
     */
    protected BlockGenericBerryBush(ResourceLocation resource, Item material) {
        super(resource, material);

        this.setCreativeTab(SimplyJuices.SimplyJuicesTab);
    }

    /**
     * @param resource
     * @param material
     * @return
     */
    public static BlockGenericBerryBush create(ResourceLocation resource, Item material) {
        BlockGenericBerryBush self = new BlockGenericBerryBush(resource, material);
        self.register();

        return self;
    }

    /**
     * @param world
     * @param random
     * @param position
     * @param state
     */
    @Override
    public void grow(World world, Random random, BlockPos position, IBlockState state) {
        super.grow(world, random, position, state);

        if (getCurrentAge(state) < getMaximumAge()) {
            int next = random.nextInt(2) + getCurrentAge(state);
            if (next <= getMaximumAge()) {
                setCurrentAge(world, position, next, 4);
            }
        }
    }

    /**
     * @param world
     * @param position
     * @param state
     * @param random
     */
    @Override
    public void updateTick(World world, BlockPos position, IBlockState state, Random random) {
        super.updateTick(world, position, state, random);

        if (random.nextInt(10) == 0 && world.getLightFromNeighbors(position) >= 8) {
            if (getCurrentAge(state) < getMaximumAge()) {
                setCurrentAge(world, position, getCurrentAge(state) + 1);
            }
        }
    }
}
