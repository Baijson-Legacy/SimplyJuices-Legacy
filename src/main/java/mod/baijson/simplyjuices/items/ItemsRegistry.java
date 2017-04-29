package mod.baijson.simplyjuices.items;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.simplyjuices.items.foods.ItemBerry;
import mod.baijson.simplyjuices.items.foods.ItemJuice;
import mod.baijson.simplyjuices.items.tools.ItemBottle;
import mod.baijson.simplyjuices.items.tools.ItemJuicer;
import mod.baijson.skeleton.client.render.IMarkedLazy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.awt.*;

/**
 * Created by Baijson.
 */
public class ItemsRegistry implements IMarkedLazy {

    static public Item itemToolJuicer;
    static public Item itemToolBottle;

    static public ItemBerry itemBerryStrawberry;
    static public ItemBerry itemBerryBlackberry;
    static public ItemBerry itemBerryGooseberry;
    static public ItemBerry itemBerrySnozzberry;
    static public ItemBerry itemBerryCloudberry;

    static public ItemJuice itemJuiceBlackberry;
    static public ItemJuice itemJuiceCloudberry;
    static public ItemJuice itemJuiceGooseberry;
    static public ItemJuice itemJuiceSnozzberry;
    static public ItemJuice itemJuiceStrawberry;

    static public ItemJuice itemJuiceVanillaApple;
    static public ItemJuice itemJuiceVanillaMelon;
    static public ItemJuice itemJuiceVanillaCarrot;


    /**
     * Load and register objects.
     */
    static public void load() {

        itemBerryBlackberry = ItemBerry.create(new ResourceLocation(SimplyJuices.MODID, "itemberryblackberry"), 2, 0.2F);
        itemBerryCloudberry = ItemBerry.create(new ResourceLocation(SimplyJuices.MODID, "itemberrycloudberry"), 2, 0.3F);
        itemBerryGooseberry = ItemBerry.create(new ResourceLocation(SimplyJuices.MODID, "itemberrygooseberry"), 3, 0.3F);
        itemBerrySnozzberry = ItemBerry.create(new ResourceLocation(SimplyJuices.MODID, "itemberrysnozzberry"), 2, 0.2F);
        itemBerryStrawberry = ItemBerry.create(new ResourceLocation(SimplyJuices.MODID, "itemberrystrawberry"), 2, 0.2F);

        itemBerryBlackberry.setColor(new Color(32, 42, 64));
        itemBerryCloudberry.setColor(new Color(224, 162, 74));
        itemBerryGooseberry.setColor(new Color(192, 211, 88));
        itemBerrySnozzberry.setColor(new Color(196, 0, 172));
        itemBerryStrawberry.setColor(new Color(206, 32, 32));

        itemJuiceBlackberry = ItemJuice.create(new ResourceLocation(SimplyJuices.MODID, "itemjuiceblackberry"), itemBerryBlackberry);
        itemJuiceCloudberry = ItemJuice.create(new ResourceLocation(SimplyJuices.MODID, "itemjuicecloudberry"), itemBerryCloudberry);
        itemJuiceGooseberry = ItemJuice.create(new ResourceLocation(SimplyJuices.MODID, "itemjuicegooseberry"), itemBerryGooseberry);
        itemJuiceSnozzberry = ItemJuice.create(new ResourceLocation(SimplyJuices.MODID, "itemjuicesnozzberry"), itemBerrySnozzberry);
        itemJuiceStrawberry = ItemJuice.create(new ResourceLocation(SimplyJuices.MODID, "itemjuicestrawberry"), itemBerryStrawberry);

        itemToolBottle = ItemBottle.create(new ResourceLocation(SimplyJuices.MODID, "itemtoolbottle"));
        itemToolJuicer = ItemJuicer.create(new ResourceLocation(SimplyJuices.MODID, "itemtooljuicer"));
        itemToolJuicer.setContainerItem(itemToolJuicer);

        GameRegistry.addShapelessRecipe(new ItemStack(itemToolJuicer), Blocks.STONE, Blocks.STONE, Blocks.STONE_BUTTON);

        if (SimplyJuices.config.enableRequireBottle) {
            GameRegistry.addRecipe(new ItemStack(itemToolBottle, 3), " X ", "G G", " G ",
                    'X', new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE),
                    'G', new ItemStack(Blocks.GLASS, 1, OreDictionary.WILDCARD_VALUE));

            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceBlackberry), itemToolJuicer, itemBerryBlackberry, itemToolBottle);
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceCloudberry), itemToolJuicer, itemBerryCloudberry, itemToolBottle);
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceGooseberry), itemToolJuicer, itemBerryGooseberry, itemToolBottle);
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceSnozzberry), itemToolJuicer, itemBerrySnozzberry, itemToolBottle);
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceStrawberry), itemToolJuicer, itemBerryStrawberry, itemToolBottle);
        } else {
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceBlackberry), itemToolJuicer, itemBerryBlackberry);
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceCloudberry), itemToolJuicer, itemBerryCloudberry);
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceGooseberry), itemToolJuicer, itemBerryGooseberry);
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceSnozzberry), itemToolJuicer, itemBerrySnozzberry);
            GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceStrawberry), itemToolJuicer, itemBerryStrawberry);
        }

        if (SimplyJuices.config.enableVanillaJuices) {

            itemJuiceVanillaApple = ItemJuice.create(new ResourceLocation(SimplyJuices.MODID, "itemjuicevanillaapple"), Items.APPLE);
            itemJuiceVanillaMelon = ItemJuice.create(new ResourceLocation(SimplyJuices.MODID, "itemjuicevanillamelon"), Items.MELON);
            itemJuiceVanillaCarrot = ItemJuice.create(new ResourceLocation(SimplyJuices.MODID, "itemjuicevanillacarrot"), Items.CARROT);

            itemJuiceVanillaApple.setColor(new Color(255, 28, 42));
            itemJuiceVanillaMelon.setColor(new Color(186, 24, 10));
            itemJuiceVanillaCarrot.setColor(new Color(255, 142, 10));

            OreDictionary.registerOre("oreBerryJuice", itemJuiceVanillaApple);
            OreDictionary.registerOre("oreBerryJuice", itemJuiceVanillaMelon);
            OreDictionary.registerOre("oreBerryJuice", itemJuiceVanillaCarrot);

            if (SimplyJuices.config.enableRequireBottle) {
                GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceVanillaApple), itemToolJuicer, Items.APPLE, itemToolBottle);
                GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceVanillaMelon), itemToolJuicer, Items.MELON, itemToolBottle);
                GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceVanillaCarrot), itemToolJuicer, Items.CARROT, itemToolBottle);
            } else {
                GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceVanillaApple), itemToolJuicer, Items.APPLE);
                GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceVanillaMelon), itemToolJuicer, Items.MELON);
                GameRegistry.addShapelessRecipe(new ItemStack(itemJuiceVanillaCarrot), itemToolJuicer, Items.CARROT);
            }
        }

        OreDictionary.registerOre("oreBerry", itemBerryBlackberry);
        OreDictionary.registerOre("oreBerry", itemBerryCloudberry);
        OreDictionary.registerOre("oreBerry", itemBerryGooseberry);
        OreDictionary.registerOre("oreBerry", itemBerrySnozzberry);
        OreDictionary.registerOre("oreBerry", itemBerryStrawberry);

        OreDictionary.registerOre("oreBerryJuice", itemJuiceBlackberry);
        OreDictionary.registerOre("oreBerryJuice", itemJuiceCloudberry);
        OreDictionary.registerOre("oreBerryJuice", itemJuiceGooseberry);
        OreDictionary.registerOre("oreBerryJuice", itemJuiceSnozzberry);
        OreDictionary.registerOre("oreBerryJuice", itemJuiceStrawberry);
    }
}