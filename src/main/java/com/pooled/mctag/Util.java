package com.pooled.mctag;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public final class Util {
    /**
     * Log a message to the server.
     */
    public static void log(String m) {
        Bukkit.getLogger().info(m);
    }

    /**
     * Return a random value from the given ArrayList.
     */
    public static<T> T choice(ArrayList<T> list) {
        return list.get((int)Math.floor(Math.random() * list.size()));
    }

    /**
     * Select a random location within the given radius of the center.
     */
    public static Location randomLocation(Location center, double radius) {
        World w = center.getWorld();
        double x = center.getX() + (Math.random() * radius * 2) - radius;
        double z = center.getZ() + (Math.random() * radius * 2) - radius;
        double y = w.getHighestBlockYAt((int)x, (int)z) + 1;
        return new Location(w, x, y, z);
    }

    /**
     * Select a random location in the world within the given radius of (0, 0).
     */
    public static Location randomLocationWithinZero(World world, double radius) {
        return randomLocation(new Location(world, 0, 0, 0), radius);
    }
}
