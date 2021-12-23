package com.pooled.mctag;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Keeps track of player score in a Tag game.
 */
public class TagScore {
    /**
     * The Tag game the TagScore belongs to.
     */
    private Tag tag;
    private Scoreboard board;
    private Objective points;

    public TagScore(Tag tag) {
        this.tag = tag;
        this.board = tag.server.getScoreboardManager().getNewScoreboard();

        // add all players to the scoreboard with a score of 0
        this.points = this.board.registerNewObjective("points", "dummy", "Points");
        this.points.setDisplaySlot(DisplaySlot.SIDEBAR);

        for (Player p : this.tag.players) {
            p.setScoreboard(this.board);
            this.points.getScore(p.getName()).setScore(0);
        }
    }

    /**
     * Grants one point to the specified player and returns their new score.
     */
    public int increment(Player p) {
        Score s = this.points.getScore(p.getName());
        int before = s.getScore();
        int after = before + 1;
        s.setScore(after);
        return after;
    }
}
