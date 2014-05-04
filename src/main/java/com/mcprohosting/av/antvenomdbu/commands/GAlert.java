package com.mcprohosting.av.antvenomdbu.commands;

import com.mcprohosting.av.antvenomdbu.AntVenomDBu;
import com.mcprohosting.plugins.dynamicbungee.data.NetTask;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class GAlert extends Command {
    public GAlert()
    {
        super("galert");
    }

    public void execute(CommandSender sender, String[] strings)
    {
        if (!sender.hasPermission("antvenomdbu.galert"))
        {
            sender.sendMessage(ChatColor.RED + "You can't perform this command!");
            return;
        }
        if (strings.length == 0)
        {
            sender.sendMessage(ChatColor.RED + "You must specify a message consisting of at least one word.");
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s).append(" ");
        }
        NetTask.withName("galert").withArg("alert", builder.toString()).withArg("sender", sender.getName()).send("dynamicbungee");


        sender.sendMessage(ChatColor.GREEN + "Alert sent.");
    }

    public static void broadcast(String alert)
    {
        ProxyServer.getInstance().broadcast(ChatColor.translateAlternateColorCodes('&', AntVenomDBu.getInstance().getConfig().getAlertPrefix() + alert));
    }
}
