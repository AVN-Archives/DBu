package com.mcprohosting.av.antvenomdbu.config;

import com.mcprohosting.av.antvenomdbu.AntVenomDBu;
import net.cubespace.Yamler.Config.Config;
import net.cubespace.Yamler.Config.InvalidConfigurationException;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

public class MainConfig extends Config{

    public MainConfig(Plugin plugin)
    {
        this.CONFIG_HEADER = new String[] { "AntVenomDBu Configuration" };
        this.CONFIG_FILE = new File(plugin.getDataFolder(), "config.yml");

        invoke();
    }

    public void invoke() {
        try {
            this.init();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private int network_maxPlayers = 100;
    private String alert_prefix = "&f[&4Alert&f] &b";

    public String getAlertPrefix()
    {
        return replaceUnicodeEscapes(this.alert_prefix);
    }

    public int getNetworkMaxPlayers()
    {
        return this.network_maxPlayers;
    }

    public void setNetworkMaxPlayers(int maxPlayers)
    {
        this.network_maxPlayers = maxPlayers;
    }

    private String replaceUnicodeEscapes(String message) {
        while (message.contains("\\u")) {
            String code = message.substring(message.indexOf("\\u") + 2, message.indexOf("\\u") + 6);
            int icode = Integer.parseInt(code, 16);
            char ccode = (char) icode;
            message = message.replace("\\u" + code, ccode + "");
        }

        return message;
    }

}
