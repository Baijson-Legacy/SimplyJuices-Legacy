package mod.baijson.simplyjuices;

import mod.baijson.simplyjuices.common.config.Config;
import mod.baijson.skeleton.client.CreativeTab;
import mod.baijson.skeleton.common.ISidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Baijson.
 */
@Mod(modid = SimplyJuices.MODID, name = SimplyJuices.MODNM, version = SimplyJuices.VERSION, dependencies = SimplyJuices.DEPENDENCIES)
public class SimplyJuices {

    /**
     * Constants.
     */
    public static final String MODID = "simplyjuices";
    public static final String MODNM = "Simply Juices";

    public static final String VERSION = "1.0.3";

    public static final String PROXY_COMMON = "mod.baijson." + MODID + ".common.CommonProxy";
    public static final String PROXY_CLIENT = "mod.baijson." + MODID + ".client.ClientProxy";

    /**
     * Dependencies.
     */
    public static final String DEPENDENCIES = "required-after:skeleton@[1.0.0,);";

    /**
     * Proxy setup
     */
    @SidedProxy(clientSide = SimplyJuices.PROXY_CLIENT, serverSide = SimplyJuices.PROXY_COMMON)
    public static ISidedProxy proxy;

    /**
     * Instance
     */
    @Mod.Instance(value = SimplyJuices.MODID)
    public static SimplyJuices instance;

    /**
     *
     */
    public static CreativeTab SimplyJuicesTab = new CreativeTab("simplyjuices");
    /**
     *
     */
    public static Config config = new Config();

    /**
     * @param event
     */
    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        config.init(event);
        proxy.init(event);
    }

    /**
     * @param event
     */
    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.load(event);
    }

    /**
     * @param event
     */
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event) {
        proxy.post(event);
    }
}
