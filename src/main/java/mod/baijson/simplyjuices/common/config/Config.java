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

    public int generationBlackberryBushRarity = 8;
    public int generationCloudberryBushRarity = 8;
    public int generationGooseberryBushRarity = 8;
    public int generationSnozzberryBushRarity = 8;
    public int generationStrawberryBushRarity = 8;

    public boolean enableRequireBottle = false;
    public boolean enableVanillaJuices = false;

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
        catWorldgen.setComment("Enable/Disable world generation per berry bush.");

        final ConfigCategory catBlackberry = new ConfigCategory("Blackberry", catWorldgen);
        final ConfigCategory catCloudberry = new ConfigCategory("Cloudberry", catWorldgen);
        final ConfigCategory catGooseberry = new ConfigCategory("Gooseberry", catWorldgen);
        final ConfigCategory catSnozzberry = new ConfigCategory("Snozzberry", catWorldgen);
        final ConfigCategory catStrawberry = new ConfigCategory("Strawberry", catWorldgen);

        generationBlackberryBushEnable = this.handle().get(catBlackberry.getQualifiedName(), "Enabled", generationBlackberryBushEnable).getBoolean();
        generationBlackberryBushRarity = this.handle().get(catBlackberry.getQualifiedName(), "Rarity", generationBlackberryBushRarity, "Min: 0 ~ Max: 10", 0, 10).getInt();
        generationCloudberryBushEnable = this.handle().get(catCloudberry.getQualifiedName(), "Enabled", generationCloudberryBushEnable).getBoolean();
        generationCloudberryBushRarity = this.handle().get(catCloudberry.getQualifiedName(), "Rarity", generationCloudberryBushRarity, "Min: 0 ~ Max: 10", 0, 10).getInt();
        generationGooseberryBushEnable = this.handle().get(catGooseberry.getQualifiedName(), "Enabled", generationGooseberryBushEnable).getBoolean();
        generationGooseberryBushRarity = this.handle().get(catGooseberry.getQualifiedName(), "Rarity", generationGooseberryBushRarity, "Min: 0 ~ Max: 10", 0, 10).getInt();
        generationSnozzberryBushEnable = this.handle().get(catSnozzberry.getQualifiedName(), "Enabled", generationSnozzberryBushEnable).getBoolean();
        generationSnozzberryBushRarity = this.handle().get(catSnozzberry.getQualifiedName(), "Rarity", generationSnozzberryBushRarity, "Min: 0 ~ Max: 10", 0, 10).getInt();
        generationStrawberryBushEnable = this.handle().get(catStrawberry.getQualifiedName(), "Enabled", generationStrawberryBushEnable).getBoolean();
        generationStrawberryBushRarity = this.handle().get(catStrawberry.getQualifiedName(), "Rarity", generationStrawberryBushRarity, "Min: 0 ~ Max: 10", 0, 10).getInt();

        enableRequireBottle = this.handle().get("General", "Juice recipes require empty bottles", enableRequireBottle).getBoolean();
        enableVanillaJuices = this.handle().get("General", "Enable recipes for Applejuice, Melonjuice and Carrotjuice", enableVanillaJuices).getBoolean();
    }
}
