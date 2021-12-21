package com.pooled.mctag;

import java.util.ArrayList;

import org.bukkit.Bukkit;

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
}
