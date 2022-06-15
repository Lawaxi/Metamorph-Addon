package net.lawaxi.metamorphadd;

import mchorse.metamorph.api.MorphManager;
import net.lawaxi.metamorphadd.actions.Skullball;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MetamorphAdd.MODID, name = MetamorphAdd.NAME, version = MetamorphAdd.VERSION)
public class MetamorphAdd
{
    public static final String MODID = "metamorphadd";
    public static final String NAME = "Metamorph Addition";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MorphManager.INSTANCE.actions.put("skullball",new Skullball());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
