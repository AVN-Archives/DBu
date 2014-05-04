package com.mcprohosting.av.antvenomdbu.tasks;

import com.mcprohosting.av.antvenomdbu.commands.GSetMaxPlayers;
import com.mcprohosting.plugins.dynamicbungee.data.NetTaskSubscribe;

import java.util.HashMap;

public class NetSetMaxPlayers {
    @NetTaskSubscribe(args={"maxplayers", "sender"}, name="gsetmaxplayers")
    public void onSetMaxPlayers(HashMap<String, Object> maxPlayersData)
    {
        GSetMaxPlayers.setMaxPlayers((String) maxPlayersData.get("maxplayers"));
    }
}
