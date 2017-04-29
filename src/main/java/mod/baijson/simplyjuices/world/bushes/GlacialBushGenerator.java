package mod.baijson.simplyjuices.world.bushes;

import mod.baijson.simplyjuices.blocks.bushes.BlockBerryBush;
import mod.baijson.skeleton.world.WorldgenBlockValidation;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Baijson.
 */
public class GlacialBushGenerator extends AbstractGenerator {

    /**
     *
     * @param material
     * @param biomes
     */
    public GlacialBushGenerator(BlockBerryBush material, BiomeDictionary.Type[] biomes) {
        super(material, biomes);
    }

    /**
     * @param world
     * @param position
     * @param random
     */
    @Override
    public void generate(World world, BlockPos position, Random random) {
        for (int x = position.getX() - 1; x <= position.getX() + 1; x++) {
            for (int z = position.getZ() - 1; z <= position.getZ() + 1; z++) {
                for (int y = position.getY() - 1; y <= position.getY() + 1; y++) {
                    BlockPos next = new BlockPos(x, y, z);
                    if (WorldgenBlockValidation.validate(world, next, new ArrayList<>(Arrays.asList(Blocks.GRASS, Blocks.DIRT)))) {
                        if (world.getBlockState(next).getBlock() == Blocks.AIR || world.getBlockState(next).getBlock() == Blocks.SNOW_LAYER && random.nextBoolean()) {
                            world.setBlockState(next, this.material.getRandomState(this.material.getDefaultState(), random), 2);
                        }
                    }
                }
            }
        }
    }
}
