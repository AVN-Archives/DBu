package com.mcprohosting.av.antvenomdbu.config;

import net.cubespace.Yamler.Config.Config;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

public class MainConfig extends Config{

    public MainConfig(Plugin plugin)
    {
        this.CONFIG_HEADER = new String[] { "AntVenomDBu Configuration" };
        this.CONFIG_FILE = new File(plugin.getDataFolder(), "config.yml");
    }

    private int network_maxPlayers = 100;
    private String alert_prefix = "&f[&4Alert&f] &b";

    public String getAlertPrefix()
    {
        return this.alert_prefix;
    }

    public int getNetworkMaxPlayers()
    {
        return this.network_maxPlayers;
    }

    public void setNetworkMaxPlayers(int maxPlayers)
    {
        this.network_maxPlayers = maxPlayers;
    }

}
