package com.tekion.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "player_bowling")
public class PlayerBowling {
    @Id
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "overs")
    private int overs;

    @Column(name = "wickets")
    private int wickets;

    @Column(name = "runs")
    private int runs;

    @Column(name = "maidens")
    private int maidens;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getMaidens() {
        return maidens;
    }

    public void setMaidens(int maidens) {
        this.maidens = maidens;
    }
}
