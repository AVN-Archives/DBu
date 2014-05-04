package com.mcprohosting.av.antvenomdbu.tasks;

import com.mcprohosting.av.antvenomdbu.commands.GAlert;
import com.mcprohosting.plugins.dynamicbungee.data.NetTaskSubscribe;

import java.util.HashMap;

public class NetAlert {
    @NetTaskSubscribe(args={"alert", "sender"}, name="galert")
    public void onSend(HashMap<String, Object> data)
    {
        GAlert.broadcast((String) data.get("alert"));
    }
}
