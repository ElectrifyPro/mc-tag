package com.pooled.mctag;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCTag extends JavaPlugin {
    static Tag tag;

    @Override
    public void onEnable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.isOp() && cmd.getName().equalsIgnoreCase("tag")) {
            Server server = getServer();
            tag = new Tag(server, server.getOnlinePlayers());
            return true;
        }

        return false; 
    }
}
