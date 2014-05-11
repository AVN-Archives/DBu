package com.mcprohosting.av.antvenomdbu.listeners;

import com.mcprohosting.av.antvenomdbu.AntVenomDBu;
import com.mcprohosting.plugins.dynamicbungee.server.ServerHeartbeatHandler;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.ArrayList;

public class JoinListener implements Listener {
    @EventHandler(priority=0)
    public void onPlayerPreLogin(PreLoginEvent event)
    {
        if (ServerHeartbeatHandler.getPlayersOnline().intValue() >= AntVenomDBu.getInstance().getConfig().getNetworkMaxPlayers())
        {
            event.setCancelReason(ChatColor.RED + "Our network is currently at full capacity, please try again shortly!");
            event.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=0)
    public void onPlayerJoin(ServerConnectEvent event)
    {
        if (event.getPlayer().getServer() == null)
        {
            handleConnectEvent(event);
        } else {
            if (event.getPlayer().getServer().getInfo().getName().toLowerCase().startsWith("game") &&
                    event.getTarget().getName().toLowerCase().startsWith("hub")) {
                handleConnectEvent(event);
            }
        }
    }

    public void handleConnectEvent(ServerConnectEvent event) {
        ArrayList<ServerInfo> destinations = new ArrayList();
        for (String info : ProxyServer.getInstance().getServers().keySet()) {
            if (info.toLowerCase().startsWith("hub"))
            {
                ServerInfo server = ProxyServer.getInstance().getServerInfo(info);
                if (server != null) {
                    destinations.add(server);
                }
            }
        }
        ServerInfo destination = null;
        for (ServerInfo server : destinations) {
            if ((destination == null) || (destination.getPlayers().size() > server.getPlayers().size())) {
                destination = server;
            }
        }
        event.setTarget(destination);
    }
}
