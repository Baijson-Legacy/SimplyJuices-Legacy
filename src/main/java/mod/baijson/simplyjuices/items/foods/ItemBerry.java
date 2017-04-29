package mod.baijson.simplyjuices.items.foods;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.skeleton.client.render.IColorAware;
import mod.baijson.skeleton.client.render.IModelAware;
import mod.baijson.skeleton.items.foods.GenericItemFood;
import mod.baijson.skeleton.items.foods.IGenericItemFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.awt.*;

/**
 * Created by Baijson.
 */
public class ItemBerry extends GenericItemFood implements IGenericItemFood, IModelAware, IColorAware {

    protected Color color;

    protected Achievement achievement;

    /**
     * @param resource
     * @param amount
     * @param saturation
     */
    protected ItemBerry(ResourceLocation resource, int amount, float saturation) {
        super(resource, amount, saturation);

        this.setCreativeTab(SimplyJuices.SimplyJuicesTab);
    }

    /**
     * @param resource
     * @param amount
     * @param saturation
     * @return
     */
    public static ItemBerry create(ResourceLocation resource, int amount, float saturation) {
        ItemBerry self = new ItemBerry(resource, amount, saturation);
        self.register();

        return self;
    }

    /**
     * @param stack
     * @return
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }


    /**
     * @param stack
     * @param world
     * @param player
     */
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);

        /**
         * Achievement
         */

        if (this.getAchievement() != null) {
            player.addStat(this.getAchievement(), 1);
        }
    }

    /**
     * @return
     */
    @Override
    public int getColor() {
        if (this.color != null) {
            return this.color.getRGB();
        }
        return 0;
    }

    /**
     * @param value
     */
    @Override
    public void setColor(Color value) {
        this.color = value;
    }

    /**
     * @param index
     * @return
     */
    @Override
    public int getColorByIndex(int index) {
        if (index == 0) {
            return this.getColor();
        }
        return -1;
    }

    /**
     * @return
     */
    public Achievement getAchievement() {
        return this.achievement;
    }

    /**
     * @param achievement
     */
    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
}
