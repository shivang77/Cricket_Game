package com.tekion.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "player_batting")
public class PlayerBatting {

    @Id
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "matches")
    private int noOfMatches;

    @Column(name = "runs")
    private int runs;

    @Column(name = "fours")
    private int fours;

    @Column(name = "sixes")
    private int sixes;

    @Column(name = "hundreds")
    private int hundreds;

    @Column(name = "fifties")
    private int fifties;

    @Column(name = "strike_rate")
    private double strike_rate;


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getNoOfMatches() {
        return noOfMatches;
    }

    public void setNoOfMatches(int noOfMatches) {
        this.noOfMatches = noOfMatches;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public double getStrike_rate() {
        return strike_rate;
    }

    public void setStrike_rate(double strike_rate) {
        this.strike_rate = strike_rate;
    }

}

