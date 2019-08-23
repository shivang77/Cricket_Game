package com.tekion.cricket.beans;

import com.tekion.cricket.util.TeamName;
import com.tekion.cricket.util.TeamScoreUtil;

import java.util.ArrayList;
import java.util.List;

public class TeamScore {

    /*
     * private instance member for a team score
     */
    private TeamName teamName;
    private int total_runs = 0;
    private int total_dots = 0;
    private int total_ones = 0;
    private int total_twos = 0;
    private int total_threes = 0;
    private int total_fours = 0;
    private int total_six = 0;
    private int total_wickets = 0;
    private int total_maiden = 0;
    private List<Over> overs;
    private Over current_over;

    public TeamScore(TeamName teamName){
        this.teamName = teamName;
    }

    /*
     * Getter methods to get Batsman property
     */
    public TeamName getTeamName() {
        return teamName;
    }

    public int getTotal_runs() {
        return total_runs;
    }

    public int getTotal_dots() {
        return total_dots;
    }

    public int getTotal_ones() {
        return total_ones;
    }

    public int getTotal_twos() {
        return total_twos;
    }

    public int getTotal_threes() {
        return total_threes;
    }

    public int getTotal_fours() {
        return total_fours;
    }

    public int getTotal_six() {
        return total_six;
    }

    public int getTotal_wickets() {
        return total_wickets;
    }

    public int getTotal_maiden() {
        return total_maiden;
    }

    public List<Over> getOvers() {
        return overs;
    }

    public Over getCurrent_over() {
        return current_over;
    }

    public double getTotalOvers(){
        if(overs!=null){
            if(current_over.getRunPerBall().size() == 6){
                return overs.size();
            }
            return overs.size() + (double)current_over.getRunPerBall().size()/10;
        }else if(current_over != null){
            return (double)current_over.getRunPerBall().size()/10;
        }
        return 0;
    }

    /*
     * Setter methods to set Batsman property
     */
    public void setTeamName(TeamName teamName) {
        this.teamName = teamName;
    }

    public void setTotal_runs(int total_runs) {
        this.total_runs = total_runs;
    }

    public void setTotal_dots(int total_dots) {
        this.total_dots = total_dots;
    }

    public void setTotal_ones(int total_ones) {
        this.total_ones = total_ones;
    }

    public void setTotal_twos(int total_twos) {
        this.total_twos = total_twos;
    }

    public void setTotal_threes(int total_threes) {
        this.total_threes = total_threes;
    }

    public void setTotal_fours(int total_fours) {
        this.total_fours = total_fours;
    }

    public void setTotal_six(int total_six) {
        this.total_six = total_six;
    }

    public void setTotal_wickets(int total_wickets) {
        this.total_wickets = total_wickets;
    }

    public void setTotal_maiden(int total_maiden) {
        this.total_maiden = total_maiden;
    }

    public void setOvers(List<Over> overs) {
        this.overs = overs;
    }

    public void setCurrent_over(Over current_over) {
        this.current_over = current_over;
    }


    /*
     * print method
     */
    @Override
    public String toString() {
        return "TeamScore{" +
                "teamName=" + teamName +
                ", total_runs=" + total_runs +
                ", total_dots=" + total_dots +
                ", total_ones=" + total_ones +
                ", total_twos=" + total_twos +
                ", total_threes=" + total_threes +
                ", total_fours=" + total_fours +
                ", total_six=" + total_six +
                ", total_wickets=" + total_wickets +
                ", total_maiden=" + total_maiden +
                '}';
    }
}
