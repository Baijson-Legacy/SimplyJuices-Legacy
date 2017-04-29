package mod.baijson.simplyjuices.world.bushes;

import mod.baijson.simplyjuices.blocks.bushes.BlockBerryBush;
import mod.baijson.skeleton.world.WorldgenPlaceValidation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Random;

/**
 * Created by Baijson.
 */
abstract public class AbstractGenerator {

    protected final BlockBerryBush material;

    protected final BiomeDictionary.Type[] biomes;

    /**
     * @param material
     */
    public AbstractGenerator(BlockBerryBush material) {
        this(material, new BiomeDictionary.Type[]{BiomeDictionary.Type.PLAINS});
    }

    /**
     * @param material
     */
    public AbstractGenerator(BlockBerryBush material, BiomeDictionary.Type[] biomes) {
        this.material = material;
        this.biomes = biomes;
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
            Biome biome = world.getBiomeForCoordsBody(new BlockPos(position.getX(), 0, position.getZ()));
            for (int i = 0; i < biomes.length; i++) {
                if (BiomeDictionary.isBiomeOfType(biome, biomes[i])) {
                    this.generate(world, generate, random);
                }
            }
        }
    }
}
