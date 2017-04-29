package mod.baijson.simplyjuices.blocks.bushes;

import mod.baijson.skeleton.blocks.GrowingBlock;
import mod.baijson.skeleton.blocks.IGrowingBlock;
import mod.baijson.skeleton.client.Tooltip;
import mod.baijson.skeleton.client.render.IColorAware;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.FakePlayer;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * Created by Baijson.
 */
public class BlockBerryBush extends GrowingBlock implements IGrowingBlock, IPlantable, IColorAware {

    protected final Item material;

    /**
     * @param resource
     */
    protected BlockBerryBush(ResourceLocation resource, Item material) {
        super(resource);

        this.material = material;
        this.setHardness(0.5F);
    }

    /**
     * @param world
     * @param position
     * @return
     */
    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos position) {
        if ((world.getBlockState(position)).getBlock() != this) {
            return this.getDefaultState();
        }
        return world.getBlockState(position);
    }

    /**
     * @param world
     * @param position
     * @return
     */
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos position) {
        return EnumPlantType.Plains;
    }

    /**
     * @param world
     * @param position
     * @param player
     */
    @Override
    public void onBlockClicked(World world, BlockPos position, EntityPlayer player) {
        if (world.isRemote)
            return;

        if (getCurrentAge(world.getBlockState(position)) == getMaximumAge()) {
            setCurrentAge(world, position, getMaximumAge() - 1);

            ItemStack drop = new ItemStack(this.material, 1);
            EntityItem item = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, drop);
            world.spawnEntityInWorld(item);

            if (!(player instanceof FakePlayer)) {
                item.onCollideWithPlayer(player);
            }
        }
    }

    /**
     * @param world
     * @param position
     * @param state
     * @param player
     * @param hand
     * @param stack
     * @param side
     * @param hitX
     * @param hitY
     * @param hitZ
     * @return
     */
    @Override
    public boolean onBlockActivated(World world, BlockPos position, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack stack, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote)
            return true;

        if (getCurrentAge(world.getBlockState(position)) == getMaximumAge()) {
            setCurrentAge(world, position, getMaximumAge() - 1);

            ItemStack drop = new ItemStack(this.material, 1);
            EntityItem item = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, drop);
            world.spawnEntityInWorld(item);

            if (!(player instanceof FakePlayer)) {
                item.onCollideWithPlayer(player);
            }
            return true;
        }
        return false;
    }

    /**
     * @param state
     * @return
     */
    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    /**
     * @param state
     * @param access
     * @param position
     * @return
     */
    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess access, BlockPos position) {
        switch (getCurrentAge(state)) {
            case 0:
                return new AxisAlignedBB(0.185D, 0.0D, 0.185D, 0.815D, 0.625D, 0.815D);
            case 1:
                return new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.750D, 0.875D);
            case 2:
                return new AxisAlignedBB(0.065D, 0.0D, 0.065D, 0.935D, 0.875D, 0.935D);
            case 3:
                return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        }
        return new AxisAlignedBB(0.185D, 0.0D, 0.185D, 0.815D, 0.625D, 0.815D);
    }

    /**
     * @return
     */
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    /**
     * @return
     */
    @Override
    public int getColor() {
        if (this.material instanceof IColorAware) {
            return ((IColorAware) this.material).getColor();
        }
        return -1;
    }

    /**
     * @param value
     */
    @Override
    public void setColor(Color value) {
        //
    }

    /**
     * @param state
     * @param world
     * @param position
     * @param index
     * @return
     */
    @Override
    public int getColorByState(IBlockState state, @Nullable IBlockAccess world, @Nullable BlockPos position, int index) {
        return index == 0 ? new Color(200, 200, 0).getRGB() : getColor();
    }

    /**
     * @param stack
     * @param player
     * @param tooltip
     * @param advanced
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        Tooltip.construct(tooltip, () -> {
            Tooltip.insert(tooltip, Tooltip.local(stack.getUnlocalizedName() + ".tooltip"));
        });
    }
}
