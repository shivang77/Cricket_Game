package com.tekion.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "team")
public class Team {

    @Id
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "match_played")
    private int matchPlayed;

    @Column(name = "match_won")
    private int matchWon;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public int getMatchWon() {
        return matchWon;
    }

    public void setMatchWon(int matchWon) {
        this.matchWon = matchWon;
    }
}
