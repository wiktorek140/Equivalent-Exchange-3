package com.pahimar.ee3.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Equivalent-Exchange-3
 * <p/>
 * ConfigurationHandler
 *
 * @author pahimar
 */
public class ConfigurationHandler
{
    public static final String CATEGORY_TRANSMUTATION = "transmutation";
    public static Configuration configuration;

    public static void init(String configPath)
    {

        GeneralConfiguration.init(new File(configPath + "general.properties"));
        BlockConfiguration.init(new File(configPath + "block.properties"));
        ItemConfiguration.init(new File(configPath + "item.properties"));
        TransmutationConfiguration.init(new File(configPath + "transmutation.properties"));
    }
}
