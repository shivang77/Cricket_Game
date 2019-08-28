package com.tekion.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "match_bowling")
@IdClass(PlayerMatchRecordPrimary.class)
public class PlayerMatchBowling {

    @Id
    private int matchId;

    @Id
    private int playerId;

    @Column(name = "overs")
    private int overs;

    @Column(name = "wickets")
    private int wickets;

    @Column(name = "maiden")
    private int maiden;

    @Column(name = "run_given")
    private int runGiven;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

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

    public int getMaiden() {
        return maiden;
    }

    public void setMaiden(int maiden) {
        this.maiden = maiden;
    }

    public int getRunGiven() {
        return runGiven;
    }

    public void setRunGiven(int runGiven) {
        this.runGiven = runGiven;
    }
}
