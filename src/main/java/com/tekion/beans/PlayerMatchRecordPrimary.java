package com.tekion.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

public class PlayerMatchRecordPrimary implements Serializable {
    @Column(name = "match_id")
    private int matchId;

    @Column(name = "player_id")
    private int playerId;

    public PlayerMatchRecordPrimary(){

    }

    public PlayerMatchRecordPrimary(int matchId, int playerId) {
        this.matchId = matchId;
        this.playerId = playerId;
    }

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
}
