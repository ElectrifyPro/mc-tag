package com.pooled.mctag;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCTag extends JavaPlugin {
    @Override
    public void onEnable() {
        Util.log("hi");
        Server server = getServer();

        server.getPluginManager().registerEvents(new PlayerMovementListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tag")) {
            return true;
        }

        return false; 
    }
}
