package com.tekion.cricket.util;

import com.tekion.cricket.beans.*;

import java.text.DecimalFormat;
import java.util.List;

public class CricketUtil {

    /*
     * To get the object of Role based on string name
     */
    public static Role getRole(String temp_role){
        Role role = Role.BATSMAN;
        switch(temp_role){
            case "batsman":
                role = Role.BATSMAN;
                break;
            case "bowler":
                role = Role.BOWLER;
                break;
            case "wk-batsman":
                role = Role.WK_BATSMAN;
                break;
            case "batting-allrounder":
                role = Role.BATTING_ALLROUNDER;
                break;
            case "bowling-allrounder":
                role = Role.BOWLING_ALLROUNDER;
                break;
        }
        return role;
    }


    /*
     * To get the object of TeamName based on string name
     */
    public static TeamName getTeamName(String tempTeamName){
        TeamName teamName = TeamName.INDIA;
        switch (tempTeamName){
            case "india":
                teamName = TeamName.INDIA;
                break;
            case "australia":
                teamName = TeamName.AUSTRALIA;
                break;
            case "england":
                teamName = TeamName.ENGLAND;
                break;
            case "afghanistan":
                teamName = TeamName.AFGHANISTAN;
                break;
            case "pakistan":
                teamName = TeamName.PAKISTAN;
                break;
            case "southafrica":
                teamName = TeamName.SOUTHAFRICA;
                break;
            case "newzealand":
                teamName = TeamName.NEWZEALAND;
                break;
            case "westindies":
                teamName =  TeamName.WESTINDIES;
                break;
            case "srilanka":
                teamName = TeamName.SRILANKA;
                break;
            case "bangladesh":
                teamName = TeamName.BANGLADESH;
                break;
        }
        return teamName;
    }


}
