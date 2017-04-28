package mod.baijson.simplyjuices.world;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.simplyjuices.blocks.BlockRegistry;
import mod.baijson.simplyjuices.world.bushes.GenericBushGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
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
    private GenericBushGenerator bushGooseberryGenerator;
    private GenericBushGenerator bushSnozzberryGenerator;
    private GenericBushGenerator bushStrawberryGenerator;

    /**
     *
     */
    public WorldBushGenerator() {

        this.bushBlackberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushBlackberry);
        this.bushCloudberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushCloudberry);
        this.bushGooseberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushGooseberry);
        this.bushSnozzberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushSnozzberry);
        this.bushStrawberryGenerator = new GenericBushGenerator(BlockRegistry.blockBushStrawberry);
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

        final int x = chunkX * 16 + 8;
        final int z = chunkZ * 16 + 8;

        final Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));


        if (SimplyJuices.config.generationBlackberryBushEnable && random.nextInt(SimplyJuices.config.generationBlackberryBushRarity) == 0) {
            if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS) || BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)) {
                this.bushBlackberryGenerator.generate(random, world, new BlockPos(x, 0, z));
            }
        }

        if (SimplyJuices.config.generationCloudberryBushEnable && random.nextInt(SimplyJuices.config.generationCloudberryBushRarity) == 0) {
            if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MOUNTAIN)) {
                this.bushCloudberryGenerator.generate(random, world, new BlockPos(x, 0, z));
            }
        }

        if (SimplyJuices.config.generationGooseberryBushEnable && random.nextInt(SimplyJuices.config.generationGooseberryBushRarity) == 0) {
            if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)) {
                this.bushGooseberryGenerator.generate(random, world, new BlockPos(x, 0, z));
            }
        }

        if (SimplyJuices.config.generationSnozzberryBushEnable && random.nextInt(SimplyJuices.config.generationSnozzberryBushRarity) == 0) {
            if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SWAMP)) {
                this.bushSnozzberryGenerator.generate(random, world, new BlockPos(x, 0, z));
            }
        }

        if (SimplyJuices.config.generationStrawberryBushEnable && random.nextInt(SimplyJuices.config.generationStrawberryBushRarity) == 0) {
            if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS)) {
                this.bushStrawberryGenerator.generate(random, world, new BlockPos(x, 0, z));
            }
        }
    }
}
