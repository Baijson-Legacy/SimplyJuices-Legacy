package mod.baijson.simplyjuices.common.config;

import mod.baijson.skeleton.common.config.ConfigFactory;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

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

    public int regenBlackberryBerryHunger = 2;
    public int regenBlackberryJuiceHunger = 4;
    public int regenCloudberryBerryHunger = 2;
    public int regenCloudberryJuiceHunger = 4;
    public int regenGooseberryBerryHunger = 3;
    public int regenGooseberryJuiceHunger = 5;
    public int regenSnozzberryBerryHunger = 2;
    public int regenSnozzberryJuiceHunger = 4;
    public int regenStrawberryBerryHunger = 2;
    public int regenStrawberryJuiceHunger = 4;

    public float regenBlackberryBerrySaturation = 0.2F;
    public float regenBlackberryJuiceSaturation = 0.3F;
    public float regenCloudberryBerrySaturation = 0.2F;
    public float regenCloudberryJuiceSaturation = 0.3F;
    public float regenGooseberryBerrySaturation = 0.3F;
    public float regenGooseberryJuiceSaturation = 0.4F;
    public float regenSnozzberryBerrySaturation = 0.2F;
    public float regenSnozzberryJuiceSaturation = 0.3F;
    public float regenStrawberryBerrySaturation = 0.2F;
    public float regenStrawberryJuiceSaturation = 0.3F;

    public int regenAppleJuiceHunger = 6;
    public int regenCarrotJuiceHunger = 5;
    public int regenMelonJuiceHunger = 4;

    public float regenAppleJuiceSaturation = 0.4F;
    public float regenCarrotJuiceSaturation = 0.4F;
    public float regenMelonJuiceSaturation = 0.4F;

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
        final ConfigCategory catRegeneration = new ConfigCategory("Hunger and Saturation values");

        final ConfigCategory catRegenBlackberry = new ConfigCategory("Blackberry", catRegeneration);
        final ConfigCategory catRegenCloudberry = new ConfigCategory("Cloudberry", catRegeneration);
        final ConfigCategory catRegenGooseberry = new ConfigCategory("Gooseberry", catRegeneration);
        final ConfigCategory catRegenSnozzberry = new ConfigCategory("Snozzberry", catRegeneration);
        final ConfigCategory catRegenStrawberry = new ConfigCategory("Strawberry", catRegeneration);

        final ConfigCategory catRegenVanilla = new ConfigCategory("Vanilla juices", catRegeneration);

        final ConfigCategory catWorldgenBlackberry = new ConfigCategory("Blackberry", catWorldgen);
        final ConfigCategory catWorldgenCloudberry = new ConfigCategory("Cloudberry", catWorldgen);
        final ConfigCategory catWorldgenGooseberry = new ConfigCategory("Gooseberry", catWorldgen);
        final ConfigCategory catWorldgenSnozzberry = new ConfigCategory("Snozzberry", catWorldgen);
        final ConfigCategory catWorldgenStrawberry = new ConfigCategory("Strawberry", catWorldgen);


        try {
            //
            regenBlackberryBerryHunger = this.handle().get(new ConfigCategory("Berry", catRegenBlackberry).getQualifiedName(), "Hunger", regenBlackberryBerryHunger, " [min: 1, max: 20, default: 2 = 1 nugget.]", 1, 20).getInt();
            regenBlackberryBerrySaturation = this.handle().getFloat("Saturation", new ConfigCategory("Berry", catRegenBlackberry).getQualifiedName(), regenBlackberryBerrySaturation, 0.0F, 20.0F, "");
            regenBlackberryJuiceHunger = this.handle().get(new ConfigCategory("Juice", catRegenBlackberry).getQualifiedName(), "Hunger", regenBlackberryJuiceHunger, " [min: 1, max: 20, default: 4 = 2 nuggets.]", 1, 20).getInt();
            regenBlackberryJuiceSaturation = this.handle().getFloat("Saturation", new ConfigCategory("Juice", catRegenBlackberry).getQualifiedName(), regenBlackberryJuiceSaturation, 0.0F, 20.0F, "");

            //
            regenCloudberryBerryHunger = this.handle().get(new ConfigCategory("Berry", catRegenCloudberry).getQualifiedName(), "Hunger", regenCloudberryBerryHunger, " [min: 1, max: 20, default: 2 = 1 nugget.]", 1, 20).getInt();
            regenCloudberryBerrySaturation = this.handle().getFloat("Saturation", new ConfigCategory("Berry", catRegenCloudberry).getQualifiedName(), regenCloudberryBerrySaturation, 0.0F, 20.0F, "");
            regenCloudberryJuiceHunger = this.handle().get(new ConfigCategory("Juice", catRegenCloudberry).getQualifiedName(), "Hunger", regenCloudberryJuiceHunger, " [min: 1, max: 20, default: 4 = 2 nuggets.]", 1, 20).getInt();
            regenCloudberryJuiceSaturation = this.handle().getFloat("Saturation", new ConfigCategory("Juice", catRegenCloudberry).getQualifiedName(), regenCloudberryJuiceSaturation, 0.0F, 20.0F, "");

            //
            regenGooseberryBerryHunger = this.handle().get(new ConfigCategory("Berry", catRegenGooseberry).getQualifiedName(), "Hunger", regenGooseberryBerryHunger, " [min: 1, max: 20, default: 3 = 1½ nugget.]", 1, 20).getInt();
            regenGooseberryBerrySaturation = this.handle().getFloat("Saturation", new ConfigCategory("Berry", catRegenGooseberry).getQualifiedName(), regenGooseberryBerrySaturation, 0.0F, 20.0F, "");
            regenGooseberryJuiceHunger = this.handle().get(new ConfigCategory("Juice", catRegenGooseberry).getQualifiedName(), "Hunger", regenGooseberryJuiceHunger, " [min: 1, max: 20, default: 5 = 2½ nuggets.]", 1, 20).getInt();
            regenGooseberryJuiceSaturation = this.handle().getFloat("Saturation", new ConfigCategory("Juice", catRegenGooseberry).getQualifiedName(), regenGooseberryJuiceSaturation, 0.0F, 20.0F, "");

            //
            regenSnozzberryBerryHunger = this.handle().get(new ConfigCategory("Berry", catRegenSnozzberry).getQualifiedName(), "Hunger", regenSnozzberryBerryHunger, " [min: 1, max: 20, default: 2 = 1 nugget.]", 1, 20).getInt();
            regenSnozzberryBerrySaturation = this.handle().getFloat("Saturation", new ConfigCategory("Berry", catRegenSnozzberry).getQualifiedName(), regenSnozzberryBerrySaturation, 0.0F, 20.0F, "");
            regenSnozzberryJuiceHunger = this.handle().get(new ConfigCategory("Juice", catRegenSnozzberry).getQualifiedName(), "Hunger", regenSnozzberryJuiceHunger, " [min: 1, max: 20, default: 4 = 2 nuggets.]", 1, 20).getInt();
            regenSnozzberryJuiceSaturation = this.handle().getFloat("Saturation", new ConfigCategory("Juice", catRegenSnozzberry).getQualifiedName(), regenSnozzberryJuiceSaturation, 0.0F, 20.0F, "");

            //
            regenStrawberryBerryHunger = this.handle().get(new ConfigCategory("Berry", catRegenStrawberry).getQualifiedName(), "Hunger", regenStrawberryBerryHunger, " [min: 1, max: 20, default: 2 = 1 nugget.]", 1, 20).getInt();
            regenStrawberryBerrySaturation = this.handle().getFloat("Saturation", new ConfigCategory("Berry", catRegenStrawberry).getQualifiedName(), regenStrawberryBerrySaturation, 0.0F, 20.0F, "");
            regenStrawberryJuiceHunger = this.handle().get(new ConfigCategory("Juice", catRegenStrawberry).getQualifiedName(), "Hunger", regenStrawberryJuiceHunger, " [min: 1, max: 20, default: 4 = 2 nuggets.]", 1, 20).getInt();
            regenStrawberryJuiceSaturation = this.handle().getFloat("Saturation", new ConfigCategory("Juice", catRegenStrawberry).getQualifiedName(), regenStrawberryJuiceSaturation, 0.0F, 20.0F, "");

            //
            regenAppleJuiceHunger = this.handle().get(new ConfigCategory("Apple juice", catRegenVanilla).getQualifiedName(), "Hunger", regenAppleJuiceHunger, " [min: 1, max: 20]", 1, 20).getInt();
            regenAppleJuiceSaturation = this.handle().getFloat("Saturation", new ConfigCategory("Apple juice", catRegenVanilla).getQualifiedName(), regenAppleJuiceSaturation, 0.0F, 20.0F, "");

            regenMelonJuiceHunger = this.handle().get(new ConfigCategory("Melon juice", catRegenVanilla).getQualifiedName(), "Hunger", regenMelonJuiceHunger, " [min: 1, max: 20]", 1, 20).getInt();
            regenMelonJuiceSaturation = this.handle().getFloat("Saturation", new ConfigCategory("Melon juice", catRegenVanilla).getQualifiedName(), regenMelonJuiceSaturation, 0.0F, 20.0F, "");

            regenCarrotJuiceHunger = this.handle().get(new ConfigCategory("Carrot juice", catRegenVanilla).getQualifiedName(), "Hunger", regenCarrotJuiceHunger, " [min: 1, max: 20]", 1, 20).getInt();
            regenCarrotJuiceSaturation = this.handle().getFloat("Saturation", new ConfigCategory("Carrot juice", catRegenVanilla).getQualifiedName(), regenCarrotJuiceSaturation, 0.0F, 20.0F, "");


            ratioBushGrowthRate = this.handle().get(catWorldgen.getQualifiedName(), "Berrybush growth rate", ratioBushGrowthRate, "How long it takes for a bush to grow to the next stage. (min: 1, max: 100, default: 20)", 1, 100).getInt();

            generationBlackberryBushEnable = this.handle().get(catWorldgenBlackberry.getQualifiedName(), "Enabled", generationBlackberryBushEnable).getBoolean();
            generationBlackberryBushRarity = this.handle().get(catWorldgenBlackberry.getQualifiedName(), "Rarity", generationBlackberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
            generationBlackberryBushRarity = (100 - generationBlackberryBushRarity);

            generationCloudberryBushEnable = this.handle().get(catWorldgenCloudberry.getQualifiedName(), "Enabled", generationCloudberryBushEnable).getBoolean();
            generationCloudberryBushRarity = this.handle().get(catWorldgenCloudberry.getQualifiedName(), "Rarity", generationCloudberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
            generationCloudberryBushRarity = (100 - generationCloudberryBushRarity);

            generationGooseberryBushEnable = this.handle().get(catWorldgenGooseberry.getQualifiedName(), "Enabled", generationGooseberryBushEnable).getBoolean();
            generationGooseberryBushRarity = this.handle().get(catWorldgenGooseberry.getQualifiedName(), "Rarity", generationGooseberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
            generationGooseberryBushRarity = (100 - generationGooseberryBushRarity);

            generationSnozzberryBushEnable = this.handle().get(catWorldgenSnozzberry.getQualifiedName(), "Enabled", generationSnozzberryBushEnable).getBoolean();
            generationSnozzberryBushRarity = this.handle().get(catWorldgenSnozzberry.getQualifiedName(), "Rarity", generationSnozzberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
            generationSnozzberryBushRarity = (100 - generationSnozzberryBushRarity);

            generationStrawberryBushEnable = this.handle().get(catWorldgenStrawberry.getQualifiedName(), "Enabled", generationStrawberryBushEnable).getBoolean();
            generationStrawberryBushRarity = this.handle().get(catWorldgenStrawberry.getQualifiedName(), "Rarity", generationStrawberryBushRarity, "Spawnrate value between 0 ~ 100. (0 = extremely rare)", 0, 100).getInt();
            generationStrawberryBushRarity = (100 - generationStrawberryBushRarity);

            enableRequireBottle = this.handle().get("General", "Juice recipes require empty bottles", enableRequireBottle).getBoolean();
            enableVanillaJuices = this.handle().get("General", "Enable recipes for Applejuice, Melonjuice and Carrotjuice", enableVanillaJuices).getBoolean();

        } catch (Exception e) {
            FMLLog.log(Level.ERROR, e.getMessage());
        }
    }
}
