package mod.baijson.simplyjuices.world.bushes;

import mod.baijson.simplyjuices.blocks.bushes.BlockBerryBush;
import mod.baijson.skeleton.world.WorldgenPlaceValidation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Baijson.
 */
abstract public class AbstractGenerator {

    protected final BlockBerryBush material;

    /**
     * @param material
     */
    public AbstractGenerator(BlockBerryBush material) {
        this.material = material;
    }

    abstract public void generate(World world, BlockPos position, Random random);

    /**
     * @param world
     * @param position
     * @param random
     */
    public void generate(Random random, World world, BlockPos position) {
        BlockPos generate = WorldgenPlaceValidation.getValidGroundPosition(world, position);
        if (generate != null) {
            this.generate(world, generate, random);
        }
    }
}
