package com.mcprohosting.av.antvenomdbu.listeners;

import com.mcprohosting.av.antvenomdbu.AntVenomDBu;
import com.mcprohosting.plugins.dynamicbungee.DynamicBungee;
import com.mcprohosting.plugins.dynamicbungee.server.ServerHeartbeatHandler;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MOTDListener implements Listener {
    @EventHandler(priority=0)
    public void onServerPing(ProxyPingEvent event)
    {
        event.setResponse(new ServerPing(event.getResponse().getVersion(),
                new ServerPing.Players(Integer.parseInt(AntVenomDBu.getInstance().getConfig().getNetworkMaxPlayers() + ""),
                                ServerHeartbeatHandler.getPlayersOnline().intValue(),
                                new ServerPing.PlayerInfo[0]),
                        ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&',
                                DynamicBungee.getPlugin().getConf().settings_motd)),
                        event.getResponse().getFaviconObject()));
    }
}
