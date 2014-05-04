package com.mcprohosting.av.antvenomdbu.commands;

import com.mcprohosting.av.antvenomdbu.AntVenomDBu;
import com.mcprohosting.plugins.dynamicbungee.DynamicBungee;
import com.mcprohosting.plugins.dynamicbungee.data.NetTask;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class GSetMaxPlayers extends Command {
    public GSetMaxPlayers()
    {
        super("gsetmaxplayers");
    }

    public void execute(CommandSender sender, String[] strings)
    {
        if (!sender.hasPermission("antvenomdbu.setmaxplayers"))
        {
            sender.sendMessage(ChatColor.RED + "You can't perform this command!");
            return;
        }
        if (strings.length != 1) {
            sender.sendMessage(ChatColor.RED + "You must specify a number to set only!");
        }
        try
        {
            Integer.parseInt(strings[0]);
        }
        catch (NumberFormatException e)
        {
            sender.sendMessage("Please specify a valid number.");
            return;
        }
        NetTask.withName("gsetmaxplayers").withArg("maxplayers", strings[0]).withArg("sender", sender.getName()).send("dynamicbungee");


        sender.sendMessage(ChatColor.GREEN + "Setting the max players of the network!");
    }

    public static void setMaxPlayers(String maxPlayers)
    {
        try
        {
            AntVenomDBu.getInstance().getConfig().setNetworkMaxPlayers(Integer.parseInt(maxPlayers));
        }
        catch (NumberFormatException e)
        {
            AntVenomDBu.getInstance().getLogger().info("That is not a valid max player value!");
        }
    }
}
