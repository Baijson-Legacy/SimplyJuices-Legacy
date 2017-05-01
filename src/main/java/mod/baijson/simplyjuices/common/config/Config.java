package mod.baijson.simplyjuices.common.config;

import mod.baijson.skeleton.common.config.ConfigFactory;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Baijson.
 */
public class Config extends ConfigFactory {

    public boolean generationBlackberryBushEnable = true;
    public boolean generationCloudberryBushEnable = true;
    public boolean generationGooseberryBushEnable = true;
    public boolean generationSnozzberryBushEnable = true;
    public boolean generationStrawberryBushEnable = true;

    public int generationBlackberryBushRarity = 65;
    public int generationCloudberryBushRarity = 85;
    public int generationGooseberryBushRarity = 85;
    public int generationSnozzberryBushRarity = 85;
    public int generationStrawberryBushRarity = 65;

    public boolean enableRequireBottle = false;
    public boolean enableVanillaJuices = false;

    public int ratioBushGrowthRate = 20;

    /**
     * @param event
     */
    @Override
    public void init(FMLPreInitializationEvent event) {
        super.init(event);
    }

    /**
     * @param configuration
     */
    @Override
    public void load(Configuration configuration) {
        super.load(configuration);

        final ConfigCategory catWorldgen = new ConfigCategory("World generation");

        final ConfigCategory catBlackberry = new ConfigCategory("Blackberry", catWorldgen);
        final ConfigCategory catCloudberry = new ConfigCategory("Cloudberry", catWorldgen);
        final ConfigCategory catGooseberry = new ConfigCategory("Gooseberry", catWorldgen);
        final ConfigCategory catSnozzberry = new ConfigCategory("Snozzberry", catWorldgen);
        final ConfigCategory catStrawberry = new ConfigCategory("Strawberry", catWorldgen);

        ratioBushGrowthRate = this.handle().get(catWorldgen.getQualifiedName(), "Berrybush growth rate", ratioBushGrowthRate, "How long it takes for a bush to grow to the next stage. (min: 1, max: 100, default: 20)", 1, 100).getInt();

        generationBlackberryBushEnable = this.handle().get(catBlackberry.getQualifiedName(), "Enabled", generationBlackberryBushEnable).getBoolean();
        generationBlackberryBushRarity = this.handle().get(catBlackberry.getQualifiedName(), "Rarity", generationBlackberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
        generationBlackberryBushRarity = (100 - generationBlackberryBushRarity);

        generationCloudberryBushEnable = this.handle().get(catCloudberry.getQualifiedName(), "Enabled", generationCloudberryBushEnable).getBoolean();
        generationCloudberryBushRarity = this.handle().get(catCloudberry.getQualifiedName(), "Rarity", generationCloudberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
        generationCloudberryBushRarity = (100 - generationCloudberryBushRarity);

        generationGooseberryBushEnable = this.handle().get(catGooseberry.getQualifiedName(), "Enabled", generationGooseberryBushEnable).getBoolean();
        generationGooseberryBushRarity = this.handle().get(catGooseberry.getQualifiedName(), "Rarity", generationGooseberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
        generationGooseberryBushRarity = (100 - generationGooseberryBushRarity);

        generationSnozzberryBushEnable = this.handle().get(catSnozzberry.getQualifiedName(), "Enabled", generationSnozzberryBushEnable).getBoolean();
        generationSnozzberryBushRarity = this.handle().get(catSnozzberry.getQualifiedName(), "Rarity", generationSnozzberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
        generationSnozzberryBushRarity = (100 - generationSnozzberryBushRarity);

        generationStrawberryBushEnable = this.handle().get(catStrawberry.getQualifiedName(), "Enabled", generationStrawberryBushEnable).getBoolean();
        generationStrawberryBushRarity = this.handle().get(catStrawberry.getQualifiedName(), "Rarity", generationStrawberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
        generationStrawberryBushRarity = (100 - generationStrawberryBushRarity);


        enableRequireBottle = this.handle().get("General", "Juice recipes require empty bottles", enableRequireBottle).getBoolean();
        enableVanillaJuices = this.handle().get("General", "Enable recipes for Applejuice, Melonjuice and Carrotjuice", enableVanillaJuices).getBoolean();
    }
}
