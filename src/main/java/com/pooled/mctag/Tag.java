package com.pooled.mctag;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Tag {
    Server server;

    /**
     * All players currently in the Tag game.
     */
    ArrayList<Player> players;
    Player it;

    /**
     * Create a Tag game with a random player as the tagger.
     */
    public<T extends Player> Tag(Server server, Collection<T> players) {
        this.server = server;
        this.players = new ArrayList<Player>(players);
        this.it = Util.choice(this.players);
    }

    /**
     * Returns a list of non-tagger players that are still in the round.
     */
    public ArrayList<Player> getAliveNonIt() {
        ArrayList<Player> list = new ArrayList<Player>();

        for (Player p : this.players) {
            if (p != this.it && !p.isDead() && p.getGameMode() == GameMode.SURVIVAL) list.add(p);
        }

        return list;
    }

    /**
     * Broadcasts a message to all players execpt for the tagger.
     */
    public void broadcastToNonIt(String s) {
        for (Player p : this.players) {
            if (p != this.it) p.sendMessage(s);
        }
    }

    /**
     * Broadcasts round start messages to players.
     */
    public void broadcastRoundStart() {
        this.server.broadcastMessage("§c§2You have 5 minutes to gather resources.");
        this.broadcastToNonIt("§2The tagger is §o§c" + this.it.getName() + "§r§2. While you cannot be tagged at the moment, you might want to stay away from them!");
        this.it.sendMessage("§cYou are the tagger! You cannot tag players until the 5 minutes is up.");

    }

    /**
     * Generates a new world border and teleports every player to a random location within it.
     */
    public void generateWorldBorder() {
        World overworld = this.server.getWorlds().get(0);
        WorldBorder border = overworld.getWorldBorder();
        Location center = Util.randomLocationWithinZero(overworld, 30_000_000); // world is approx. 30 million blocks wide
        border.setCenter(center.getX(), center.getY());
        border.setSize(500);

        this.it.teleport(Util.randomLocation(border.getCenter(), 225));

        // non-tagger players are teleported close (~15 blocks) to each other
        Location last = null;
        for (Player p : this.getAliveNonIt()) {
            if (last == null) {
                last = Util.randomLocation(border.getCenter(), 225);
            } else {
                last = Util.randomLocation(last, 15);
                while (!border.isInside(last)) last = Util.randomLocation(last, 15);
            }

            p.teleport(last);
        }
    }

    // TODO
    public void start() {
        // create and teleport all players to a random location in the world border
        this.generateWorldBorder();

        // give seeker glowing effect with no particles
        this.it.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 1_000_000, 1, false, false));

        this.server.broadcastMessage("§c§lGame started!");
        this.broadcastRoundStart();
    }
}
