package com.mcprohosting.av.antvenomdbu;

import com.mcprohosting.av.antvenomdbu.config.MainConfig;
import lombok.Getter;
import net.cubespace.Yamler.Config.InvalidConfigurationException;
import net.md_5.bungee.api.plugin.Plugin;

public class AntVenomDBu extends Plugin {

    @Getter
    private static AntVenomDBu instance;

    @Getter
    private MainConfig config;

    public void onEnable() {
        instance = this;
        this.config = new MainConfig(instance);
        try
        {
            this.config.init();
        }
        catch (InvalidConfigurationException e)
        {
            e.printStackTrace();
        }
    }

}
