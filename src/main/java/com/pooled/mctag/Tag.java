package com.pooled.mctag;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Server;
import org.bukkit.entity.Player;

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

    // TODO
    public void start() {
        server.broadcastMessage("Game will start in 5 seconds!");
    }
}
