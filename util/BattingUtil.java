package com.tekion.cricket.util;

import com.tekion.cricket.beans.Batting;

public class BattingUtil {

    /*
     * private constructor
     */
    public BattingUtil(){

    }

    /*
     * Update the batsman scores details
     */
    public static Batting updateBattingRecord(Batting batting, int run){

        // Update total runs
        if(run != 7) {
            batting.setTotal_runs(batting.getTotal_runs() + run);
        }

        // Update total balls played
        batting.setTotal_balls(batting.getTotal_balls() + 1);

        /*
         * Switch statement to update total dots, ones, twos, fours, six or wicket
         */
        switch(run){
            case 0: batting.setTotal_dots(batting.getTotal_dots() + 1);
                break;
            case 1: batting.setTotal_ones(batting.getTotal_ones() + 1);
                break;
            case 2: batting.setTotal_twos(batting.getTotal_twos() + 1);
                break;
            case 3: batting.setTotal_threes(batting.getTotal_threes() + 1);
                break;
            case 4: batting.setTotal_fours(batting.getTotal_fours() + 1);
                break;
            case 6: batting.setTotal_six(batting.getTotal_six() + 1);
                    break;
            case 7: batting.setIsOut(1);
                break;
        }

        return batting;
    }
}
