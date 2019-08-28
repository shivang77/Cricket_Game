package com.tekion.beans;

import javax.persistence.*;

@Entity(name = "match_batting")
@IdClass(PlayerMatchRecordPrimary.class)
public class PlayerMatchBatting {


    //    @EmbeddedId
    //    private PlayerMatchBattingPK playerMatchBattingPK;

    @Id
    @Column(name = "player_id")
    private int playerId;

    @Id
    @Column(name = "match_id")
    private int matchId;


    @Column(name = "score")
    private int score;

    @Column(name = "ball_played")
    private int ball_played;

    @Column(name = "fours")
    private int fours;

    @Column(name = "six")
    private int six;

    @Column(name = "is_out")
    private int isOut;

    public  PlayerMatchBatting(){

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBall_played() {
        return ball_played;
    }

    public void setBall_played(int ball_played) {
        this.ball_played = ball_played;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public int getIsOut() {
        return isOut;
    }

    public void setIsOut(int isOut) {
        this.isOut = isOut;
    }
}
