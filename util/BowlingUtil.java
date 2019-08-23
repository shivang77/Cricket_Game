package com.tekion.cricket.util;

import com.tekion.cricket.beans.Bowling;
import com.tekion.cricket.beans.Over;

import java.util.ArrayList;
import java.util.List;

public class BowlingUtil {

    /*
     * private Consturctor
     */
    private BowlingUtil(){

    }

    /*
     * Adding over for a bowler to overs field
     */
    public static Bowling addOver(Bowling bowling, Over current_over){
        if(bowling.getOvers() == null){
            bowling.setOvers(new ArrayList<>());
        }
        bowling.getOvers().add(current_over);

        if(current_over.getTotalRuns() == 0){
            bowling.setTotal_maiden(bowling.getTotal_maiden() + 1);
        }
        return bowling;
    }

    /*
     * updating bowler record with each bowl and if over is completed then it will call addOver method
     */
    public static Bowling updateBowlerRecord(Bowling bowling, int run, Over over){
        if(run == 7){
            bowling.setTotal_wickets(bowling.getTotal_wickets() + 1);
        }else{
            bowling.setTotal_runs(bowling.getTotal_runs() + run);
        }
        bowling.setCurrent_over(over);
        if(bowling.getCurrent_over().getRunPerBall().size() == 6){
            addOver(bowling, over);
        }
        return bowling;
    }

    /*
     * To get the total overs bowler has bowled
     */
    public static double getTotalOvers(Bowling bowling){
        if(bowling.getOvers()!=null){
            if(bowling.getCurrent_over().getRunPerBall().size() == 6){
                return bowling.getOvers().size();
            }
            return bowling.getOvers().size() + (double)bowling.getCurrent_over().getRunPerBall().size()/10;
        }else if(bowling.getCurrent_over() != null){
            return (double)bowling.getCurrent_over().getRunPerBall().size()/10;
        }
        return 0;
    }

}



