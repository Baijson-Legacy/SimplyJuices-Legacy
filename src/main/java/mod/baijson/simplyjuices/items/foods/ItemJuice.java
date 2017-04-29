package mod.baijson.simplyjuices.items.foods;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.skeleton.client.render.IColorAware;
import mod.baijson.skeleton.client.render.IModelAware;
import mod.baijson.skeleton.items.foods.GenericItemFood;
import mod.baijson.skeleton.items.foods.IGenericItemFood;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

/**
 * Created by Baijson.
 */
public class ItemJuice extends GenericItemFood implements IGenericItemFood, IModelAware, IColorAware {

    protected Color color;

    /**
     * @param resource
     * @param amount
     * @param saturation
     */
    protected ItemJuice(ResourceLocation resource, int amount, float saturation) {
        super(resource, amount, saturation);

        this.setCreativeTab(SimplyJuices.SimplyJuicesTab);
    }

    /**
     * @param resource
     * @param material
     * @return
     */
    public static ItemJuice create(ResourceLocation resource, Item material) {
        ItemJuice self = null;
        try {
            if (material instanceof ItemFood) {

                ItemStack stack = new ItemStack(material);

                int hunger = ((ItemFood) stack.getItem()).getHealAmount(stack);
                float saturation = ((ItemFood) stack.getItem()).getSaturationModifier(stack);

                self = new ItemJuice(resource, hunger + (material instanceof ItemBerry ? 2 : 1), saturation + 0.1F);

                if (stack.getItem() instanceof IColorAware) {
                    self.setColor(new Color(((IColorAware) stack.getItem()).getColor()));
                }
            }

            if (self != null) {
                self.register();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return self;
    }

    /**
     * @param stack
     * @return
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
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
}
