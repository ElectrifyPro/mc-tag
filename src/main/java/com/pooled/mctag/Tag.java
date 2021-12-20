package com.pooled.mctag;

import java.util.Collection;

import org.bukkit.Server;
import org.bukkit.entity.Player;

public class Tag {
    Server server;

    /**
     * All players currently in the Tag game.
     */
    Player[] players;
    Player it;

    /**
     * Create a Tag game with a random player as the tagger.
     */
    public<T> Tag(Server server, Collection<T> players) {
        this.server = server;
        this.players = players.toArray(new Player[players.size()]);
        this.it = Util.choice(this.players);
    }

    // TODO
    public void start() {
        server.broadcastMessage("Game will start in 5 seconds!");
    }
}
