package mod.baijson.simplyjuices.common;

import mod.baijson.simplyjuices.SimplyJuices;
import mod.baijson.simplyjuices.blocks.BlockRegistry;
import mod.baijson.simplyjuices.items.ItemsRegistry;
import mod.baijson.simplyjuices.world.WorldBushGenerator;
import mod.baijson.skeleton.common.ISidedProxy;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Baijson.
 */
public class CommonProxy implements ISidedProxy {

    private static Achievement snozzBerryAchievement;

    /**
     * @param event
     */
    @Override
    public void init(FMLPreInitializationEvent event) {
        ItemsRegistry.load();
        BlockRegistry.load();

        /**
         * Achievement!
         */
        snozzBerryAchievement = new Achievement("achievement.snozzberry", "snozzberry", 0, 0, ItemsRegistry.itemBerrySnozzberry, (Achievement) null).registerStat();
        AchievementPage.registerAchievementPage(new AchievementPage(SimplyJuices.MODNM, snozzBerryAchievement));

        ItemsRegistry.itemBerrySnozzberry.setAchievement(snozzBerryAchievement);
    }

    /**
     * @param event
     */
    @Override
    public void load(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new WorldBushGenerator(), 0);
    }

    /**
     * @param event
     */
    @Override
    public void post(FMLPostInitializationEvent event) {

    }
}
