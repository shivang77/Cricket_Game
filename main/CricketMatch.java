package com.tekion.cricket.main;

import com.tekion.cricket.beans.*;
import com.tekion.cricket.controller.CricketController;
import com.tekion.cricket.controller.MatchController;
import com.tekion.cricket.controller.TeamController;
import com.tekion.cricket.util.*;

import java.util.Map;

public class CricketMatch {
    public static void main(String[] args) {

        int series_id = 1;
        int no_of_matches = 2;
        int match_id = MatchController.getMaxMatchId();

        /*
         * Getting series details
         */
        Map<String, String> series_details = CricketController.getSeriesDetails(series_id);
        String series_name = series_details.get("series_name");

        /*
         *create teams
         */
        int first_team_id = Integer.parseInt(series_details.get("first_team_id"));
        int second_team_id = Integer.parseInt(series_details.get("second_team_id"));
        TeamName first_team_name = TeamController.getTeamName(first_team_id);
        TeamName second_team_name = TeamController.getTeamName(second_team_id);
        Team first_team;
        Team second_team;

        for(int match_number = match_id+1 ; match_number <= match_id + no_of_matches; match_number++){

            first_team = MatchUtil.createTeam(first_team_id, first_team_name);
            second_team = MatchUtil.createTeam(second_team_id, second_team_name);

            /*
             * create match class instance including first_team, second_team, toss_won_by, toss_win_choice
             */
            Match match = new Match.Builder().setFirst_team(first_team).setSecond_team(second_team).setOvers(MatchConstants.NO_OF_OVERS).build();
            match = MatchUtil.tossAndItsResult(match);

            Team batting_first = match.getTeam_batting_first();
            Team bowling_first = match.getTeam_balling_first();

            TeamScore batting_first_team_score = null;
            TeamScore bowling_first_team_score = null;

            /*
             * Innings result
             */
            batting_first_team_score = MatchUtil.inningScore(batting_first, bowling_first,
                    false, 0);

            bowling_first_team_score = MatchUtil.inningScore(bowling_first, batting_first,
                    true, batting_first_team_score.getTotal_runs());

            /*
             * Result of who won the match
             */
            if(batting_first_team_score.getTotal_runs() > bowling_first_team_score.getTotal_runs()){
                match.setMatch_won_by(batting_first.getTeamName());
            }else{
                match.setMatch_won_by(bowling_first.getTeamName());
            }

            /*
             * Update the database
             */
            MatchController.insertMatchRecords(match,series_id,match_number);

            /*
             * To print the scoreboard
             */
            TeamScoreUtil.showScoreBoard(match, batting_first_team_score, bowling_first_team_score);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
