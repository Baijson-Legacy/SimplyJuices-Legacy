package mod.baijson.simplyjuices.world;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.simplyjuices.blocks.BlockRegistry;
import mod.baijson.simplyjuices.world.bushes.GenericBushGenerator;
import mod.baijson.simplyjuices.world.bushes.GlacialBushGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Baijson.
 */
public class WorldBushGenerator implements IWorldGenerator {

    private GenericBushGenerator bushBlackberryGenerator;
    private GenericBushGenerator bushCloudberryGenerator;
    private GlacialBushGenerator bushGooseberryGenerator;
    private GenericBushGenerator bushSnozzberryGenerator;
    private GenericBushGenerator bushStrawberryGenerator;

    /**
     *
     */
    public WorldBushGenerator() {
        this.bushBlackberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushBlackberry, new BiomeDictionary.Type[]{BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.FOREST});
        this.bushCloudberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushCloudberry, new BiomeDictionary.Type[]{BiomeDictionary.Type.MOUNTAIN});
        this.bushGooseberryGenerator = new GlacialBushGenerator(BlockRegistry.blockBushGooseberry, new BiomeDictionary.Type[]{BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY});
        this.bushSnozzberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushSnozzberry, new BiomeDictionary.Type[]{BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.MAGICAL});
        this.bushStrawberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushStrawberry, new BiomeDictionary.Type[]{BiomeDictionary.Type.PLAINS});
    }

    /**
     * Generate some world
     *
     * @param random    the chunk specific {@link Random}.
     * @param chunkX    the chunk X coordinate of this chunk.
     * @param chunkZ    the chunk Z coordinate of this chunk.
     * @param world     : additionalData[0] The minecraft {@link World} we're generating for.
     * @param generator : additionalData[1] The {@link IChunkProvider} that is generating.
     * @param provider  : additionalData[2] {@link IChunkProvider} that is requesting the world generation.
     */
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider) {

        int x = chunkX * 16 + 8;
        int z = chunkZ * 16 + 8;

        if (SimplyJuices.config.generationBlackberryBushEnable && random.nextInt(SimplyJuices.config.generationBlackberryBushRarity) == 0) {
            this.bushBlackberryGenerator.generate(random, world, new BlockPos(x, 0, z));
        }

        if (SimplyJuices.config.generationCloudberryBushEnable && random.nextInt(SimplyJuices.config.generationCloudberryBushRarity) == 0) {
            this.bushCloudberryGenerator.generate(random, world, new BlockPos(x, 0, z));
        }

        if (SimplyJuices.config.generationGooseberryBushEnable && random.nextInt(SimplyJuices.config.generationGooseberryBushRarity) == 0) {
            this.bushGooseberryGenerator.generate(random, world, new BlockPos(x, 0, z));
        }

        if (SimplyJuices.config.generationSnozzberryBushEnable && random.nextInt(SimplyJuices.config.generationSnozzberryBushRarity) == 0) {
            this.bushSnozzberryGenerator.generate(random, world, new BlockPos(x, 0, z));
        }

        if (SimplyJuices.config.generationStrawberryBushEnable && random.nextInt(SimplyJuices.config.generationStrawberryBushRarity) == 0) {
            this.bushStrawberryGenerator.generate(random, world, new BlockPos(x, 0, z));
        }
    }
}
