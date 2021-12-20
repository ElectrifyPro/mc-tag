package com.pooled.mctag;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovementListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        Location l = p.getLocation();
        Block b = l.getBlock().getRelative(BlockFace.DOWN);
        if (b.getType() == Material.GRASS_BLOCK) {
            World w = p.getWorld();
            w.createExplosion(l, 4);
        }
    }
}
