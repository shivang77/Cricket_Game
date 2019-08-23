package com.tekion.cricket.beans;

import com.tekion.cricket.util.BowlingUtil;

import java.util.ArrayList;
import java.util.List;

public class Bowling {

    /*
     * private instance member for a bowler
     */
    private List<Over> overs;
    private int total_wickets = 0;
    private int total_maiden = 0;
    private int total_runs = 0;
    private Over current_over;
    private int total_overs = 0;

    /*
     * Constructor
     */
    public Bowling(int total_wickets, int total_maiden, int total_runs, int total_overs) {
        this.total_wickets = total_wickets;
        this.total_maiden = total_maiden;
        this.total_runs = total_runs;
        this.total_overs = total_overs;
    }

    public Bowling(){

    }

    /*
     * Getter methods to get Over property
     */
    public List<Over> getOvers() {
        return overs;
    }

    public Over getCurrent_over() {
        return current_over;
    }

    public int getTotal_wickets() {
        return total_wickets;
    }

    public int getTotal_maiden() {
        return total_maiden;
    }

    public int getTotal_runs() {
        return total_runs;
    }

    /*
     * Setter methods to set Over property
     */
    public void setOvers(List<Over> overs) {
        this.overs = overs;
    }

    public void setTotal_wickets(int total_wickets) {
        this.total_wickets = total_wickets;
    }

    public void setTotal_maiden(int total_maiden) {
        this.total_maiden = total_maiden;
    }

    public void setTotal_runs(int total_runs) {
        this.total_runs = total_runs;
    }

    public void setCurrent_over(Over current_over) {
        this.current_over = current_over;
    }

    public void setTotal_overs(int total_overs) {
        this.total_overs = total_overs;
    }

    /*
     * Method to print bowling specification for each bowler
     */

    @Override
    public String toString() {
        return BowlingUtil.getTotalOvers(this) +
                " - " + total_maiden +
                " - " + total_runs +
                " - " + total_wickets;
    }
}
