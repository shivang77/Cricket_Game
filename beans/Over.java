package com.tekion.cricket.beans;

import java.util.ArrayList;
import java.util.List;

public class Over implements Cloneable{

    /*
     * private instance member for each Over
     */
    private List<Integer> runPerBall;
    private Player bowler;
    private int totalRuns=0;
    private int totalWickets=0;

    public Over(Player bowler){
        runPerBall = new ArrayList<>();
        this.bowler = bowler;
    }

    /*
     * Setter methods to set Over property
     */
    public void setBowler(Player bowler) {
        Player temp_bowler = bowler;
        this.bowler = temp_bowler;
    }

    public void setRunPerBall(int run){
        runPerBall.add(run);
        if(run != 7){
            totalRuns += run;
        }else{
            totalWickets += 1;
        }
    }

    private void setRunPerBallList(List<Integer> runPerBall){
        this.runPerBall = runPerBall;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<Integer> runPerBall = new ArrayList<>();
        runPerBall.addAll(this.runPerBall);
        Over copyOver = (Over)super.clone();
        copyOver.setRunPerBallList(runPerBall);
        return copyOver;
    }

    public Over copy(){
        try{
            return (Over)clone();
        }catch(CloneNotSupportedException c){
            c.printStackTrace();
        }
        return null;
    }

    /*
     * Getter methods to get Over property
     */
    public List<Integer> getRunPerBall() {
        return runPerBall;
    }

    public Player getBowler() {
        return bowler;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    /*
     * Method to print over specification
     */
    @Override
    public String toString() {
        return "Over{" +
                "runPerBall=" + runPerBall +
                ", bowler=" + bowler.getName() +
                ", totalRuns=" + totalRuns +
                ", totalWickets=" + totalWickets +
                '}';
    }
}
