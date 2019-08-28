package com.tekion.beans;

import javax.persistence.*;

@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "match_id")
    private int matchId;
    @Column(name= "series_id")
    private int seriesId;
    @Column(name= "toss_won_by")
    private String tossWonBy;
    @Column(name= "match_won_by")
    private String matchWonBy;
    @Column(name= "overs")
    private int overs;


    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public String getTossWonBy() {
        return tossWonBy;
    }

    public void setTossWonBy(String tossWonBy) {
        this.tossWonBy = tossWonBy;
    }

    public String getMatchWonBy() {
        return matchWonBy;
    }

    public void setMatchWonBy(String matchWonBy) {
        this.matchWonBy = matchWonBy;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }
}
