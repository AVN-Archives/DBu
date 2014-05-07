package com.mcprohosting.av.antvenomdbu;

import com.mcprohosting.av.antvenomdbu.commands.GAlert;
import com.mcprohosting.av.antvenomdbu.commands.GSetMaxPlayers;
import com.mcprohosting.av.antvenomdbu.config.MainConfig;
import com.mcprohosting.av.antvenomdbu.listeners.JoinListener;
import com.mcprohosting.av.antvenomdbu.listeners.MOTDListener;
import com.mcprohosting.av.antvenomdbu.tasks.NetAlert;
import com.mcprohosting.av.antvenomdbu.tasks.NetSetMaxPlayers;
import com.mcprohosting.plugins.dynamicbungee.DynamicBungee;
import lombok.Getter;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class AntVenomDBu extends Plugin {

    @Getter
    private static AntVenomDBu instance;

    @Getter
    private MainConfig config;

    public void onEnable() {
        instance = this;
        this.config = new MainConfig(this);

        registerListeners();
        registerCommands();
    }

    private void registerCommands() {
        DynamicBungee.getPlugin().getDispatch().registerTasks(new NetAlert());
        DynamicBungee.getPlugin().getDispatch().registerTasks(new NetSetMaxPlayers());

        ProxyServer.getInstance().getPluginManager().registerCommand(this, new GAlert());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new GSetMaxPlayers());
    }

    private void registerListeners() {
        ProxyServer.getInstance().getPluginManager().registerListener(this, new JoinListener());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new MOTDListener());
    }

}
