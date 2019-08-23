package com.tekion.cricket.util;

import com.tekion.cricket.beans.*;
import com.tekion.cricket.controller.TeamController;

import java.util.List;
import java.util.Random;

public class MatchUtil {

    /*
     * private constructor
     */
    private MatchUtil(){

    }

    /*
     * To create Teams
     */
    public static Team createTeam(int team_id, TeamName teamName){
        List<Player> players = TeamController.getPlayers(team_id, teamName);
        return new Team.Builder().setTeamName(teamName).setPlayers(players).setCaptain(players.get(0))
                .setVice_captain(players.get(1)).build();
    }


    /*
     * Generate random number with some probability
     */
    public static int generateRandomRun(Random random){
        int probability = random.nextInt(100) + 1;

        if(probability <= 20){
            return 0;
        }else if(probability > 20 && probability <= 50){
            return 1;
        }else if(probability > 50 && probability <= 65){
            return 2;
        }else if(probability > 65 && probability <= 75){
            return 3;
        }else if(probability > 75 && probability <= 85){
            return 4;
        }else if(probability > 85 && probability <= 95){
            return 6;
        }else{
            return 7;
        }
    }


    /*
     * setting the team winning toss and its choice in match object
     */
    public static Match tossAndItsResult(Match match){
        Random random = new Random();

        /*
         * Toss
         */
        int toss_winning_team = random.nextInt(2)+1;
        if(toss_winning_team == 1){
            match.setToss_won_by(match.getFirst_team().getTeamName());
        }else{
            match.setToss_won_by(match.getSecond_team().getTeamName());
        }

        /*
         * Selection of Batting or Bowling based on toss
         */
        int toss_win_choice = random.nextInt(2)+1;
        if(toss_win_choice == 1){
            match.setToss_win_choice(TossWinChoice.BATTING);
        }else{
            match.setToss_win_choice(TossWinChoice.BOWLING);
        }

        return match;
    }

    /*
     * To Process one inning at a time
     */
    public static TeamScore inningScore(Team batting_team, Team bowling_team, boolean second_inning, int run_scored_by_first_team){
        TeamScore score = new TeamScore(batting_team.getTeamName());
        Random random = new Random();
        int previous_bowler_position = -1;
        int bowler_position;
        int striker_batsman_position = 0;
        int non_striker_batsman_position = 1;
        Batting striker_batsman_batting = batting_team.getPlayers().get(striker_batsman_position).getBatting();
        Batting non_striker_batsman_batting = batting_team.getPlayers().get(non_striker_batsman_position).getBatting();
        Bowling bowling;
        int score_on_each_ball;
        int temp;
        Batting temp_batting;

        for(int over_number = 1; over_number <= MatchConstants.NO_OF_OVERS && score.getTotal_wickets()<10; over_number++){
            bowler_position = random.nextInt(5) + 6;

            /*
             * check if the new bowler must not same as previous bowler
             */
            while(previous_bowler_position == bowler_position){
                bowler_position = random.nextInt(5) + 6;
            }

            /*
             * initializing bowler and over instances
             */
            bowling = bowling_team.getPlayers().get(bowler_position).getBowling();
            Over over = new Over(bowling_team.getPlayers().get(bowler_position));

            for(int ball_number = 1; ball_number < 7 && score.getTotal_wickets()<10; ball_number++){

                score_on_each_ball = MatchUtil.generateRandomRun(random);
                over.setRunPerBall(score_on_each_ball);

                /*
                 * team score updated after each ball
                 */
                TeamScoreUtil.updateScore(score, score_on_each_ball, over.copy());

                /*
                 * bowler stats updated after each ball
                 */
                bowling = BowlingUtil.updateBowlerRecord(bowling, score_on_each_ball, over.copy());
                bowling_team.getPlayers().get(bowler_position).setBowling(bowling);

                /*
                 * batsman score updated after each bowl
                 */
                striker_batsman_batting = BattingUtil.updateBattingRecord(striker_batsman_batting, score_on_each_ball);
                batting_team.getPlayers().get(striker_batsman_position).setBatting(striker_batsman_batting);

                switch (score_on_each_ball){

                    // In case of odd runs batsman will be changing strike
                    case 1:
                    case 3:
                    case 5:
                        temp = striker_batsman_position;
                        striker_batsman_position = non_striker_batsman_position;
                        non_striker_batsman_position = temp;
                        temp_batting = striker_batsman_batting;
                        striker_batsman_batting = non_striker_batsman_batting;
                        non_striker_batsman_batting = temp_batting;
                        break;
                    // In case of wicket check no of wickets and change the striker batsman
                    case 7:
                        if(score.getTotal_wickets() == 10) {
                            return score;
                        }
                        striker_batsman_position = score.getTotal_wickets()+1;
                        striker_batsman_batting = batting_team.getPlayers().get(striker_batsman_position).getBatting();
                        break;
                }

                // To check that second inning score should not exceed first_inning score
                if(second_inning){
                    if(score.getTotal_runs() > run_scored_by_first_team){
                        return score;
                    }
                }
            }

            /*
             * after each over batsman will change their position
             */
            temp = striker_batsman_position;
            striker_batsman_position = non_striker_batsman_position;
            non_striker_batsman_position = temp;
            temp_batting = striker_batsman_batting;
            striker_batsman_batting = non_striker_batsman_batting;
            non_striker_batsman_batting = temp_batting;

            /*
             * To keep track of previous bowler so that same bowler can't repeat
             */
            previous_bowler_position = bowler_position;
        }
        return score;
    }

}
