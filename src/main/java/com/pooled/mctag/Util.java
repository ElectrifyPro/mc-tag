package com.pooled.mctag;

import org.bukkit.Bukkit;

public final class Util {
    /**
     * Log a message to the server.
     */
    public static void log(String m) {
        Bukkit.getLogger().info(m);
    }

    /**
     * Return a random value from the given array.
     */
    public static<T> T choice(T[] array) {
        return array[(int)Math.floor(Math.random() * array.length)];
    }
}
