package com.tekion.cricket.util;

import com.tekion.cricket.beans.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TeamScoreUtil {

    /*
     * private constructor
     */
    private TeamScoreUtil(){

    }

    /*
     * Adding over for a bowler to overs field
     */
    private static void addOver(TeamScore teamScore, Over current_over){
        if(teamScore.getOvers() == null){
            teamScore.setOvers(new ArrayList<>());
        }
        teamScore.getOvers().add(current_over);
        if(current_over.getTotalRuns() == 0){
            teamScore.setTotal_maiden(teamScore.getTotal_maiden() + 1);
        }
    }

    /*
     * updating bowler record with each bowl and if over is completed then it will call addOver method
     */
    public static void updateScore(TeamScore teamScore, int run, Over over){
        if(run != 7){
            teamScore.setTotal_runs(teamScore.getTotal_runs() + run);
        }
        switch(run){
            case 0: teamScore.setTotal_dots(teamScore.getTotal_dots() + 1);
                break;
            case 1: teamScore.setTotal_ones(teamScore.getTotal_ones() + 1);
                break;
            case 2: teamScore.setTotal_twos(teamScore.getTotal_twos() + 1);
                break;
            case 3: teamScore.setTotal_threes(teamScore.getTotal_threes() + 1);
                break;
            case 4: teamScore.setTotal_fours(teamScore.getTotal_fours() + 1);
                break;
            case 6: teamScore.setTotal_six(teamScore.getTotal_six() + 1);
                break;
            case 7: teamScore.setTotal_wickets(teamScore.getTotal_wickets() + 1);
                break;
        }
        teamScore.setCurrent_over(over);
        if(teamScore.getCurrent_over().getRunPerBall().size() == 6){
            TeamScoreUtil.addOver(teamScore, teamScore.getCurrent_over());
        }
    }

    /*
     * To print the scoreboard
     */
    public static void showScoreBoard(Match match, TeamScore batting_first_team_score, TeamScore bowling_first_team_score){
        showHeader(match);

        if(batting_first_team_score != null)
            showScore(match.getTeam_batting_first(),match.getTeam_balling_first(),batting_first_team_score);

        System.out.println();
        System.out.println();

        if(bowling_first_team_score != null)
            showScore(match.getTeam_balling_first(),match.getTeam_batting_first(),bowling_first_team_score);
    }

    /*
     * To print the header of scoreboard
     */
    private static void showHeader(Match match){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t\t==========================================");
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\tScore Board");
        System.out.println();
        System.out.println("\t\t\t\t\t==========================================");
        System.out.println();
        System.out.println();
        System.out.println(match.getToss_won_by()+" won the Toss");
        if(match.getMatch_won_by() != null){
            System.out.println(match.getMatch_won_by()+" won the Match");
        }
        System.out.println();
        System.out.println();
    }

    /*
     * To show the score
     */
    private static void showScore(Team batting_team, Team bowling_team, TeamScore teamScore){
        List<Player> batting_team_player = batting_team.getPlayers();
        List<Player> bowling_team_player = bowling_team.getPlayers();

        System.out.println();

        System.out.println(batting_team.getTeamName() + "\t\t\t\t" +teamScore.getTotal_runs() + "-"
                + teamScore.getTotal_wickets() + " (" + teamScore.getTotalOvers()+")");

        int space_count = 17;
        Batting batting;

        System.out.println();
        System.out.print("Batsman");
        while(space_count-- > 0){
            System.out.print(" ");
        }
        System.out.println("R\tB\t4s\t6s\tSR");

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);

        for(Player player:batting_team_player){
            batting = player.getBatting();
            if(batting.getTotal_balls() != 0){
                System.out.print(player.getName());
                space_count = 24-player.getName().length();
                if(batting.getIsOut() == 0){
                    System.out.print("*");
                    space_count--;
                }
                while(space_count-- > 0){
                    System.out.print(" ");
                }
                System.out.println(batting.getTotal_runs() + "\t" + batting.getTotal_balls()
                        + "\t" + batting.getTotal_fours() + "\t" + batting.getTotal_six() + "\t"
                        +df.format(((double)batting.getTotal_runs()/batting.getTotal_balls())*100));
            }
        }

        System.out.println();
        System.out.println("Bowler");
        System.out.println();

        Bowling bowling;
        df.setMaximumFractionDigits(1);
        for(Player player:bowling_team_player){
            bowling = player.getBowling();
            if(Double.compare(BowlingUtil.getTotalOvers(bowling),0) != 0){
                System.out.print(player.getName());
                space_count = 24-player.getName().length();
                while(space_count-- > 0){
                    System.out.print(" ");
                }
                System.out.println(df.format(BowlingUtil.getTotalOvers(bowling)) + "\t" + bowling.getTotal_maiden()
                        + "\t" + bowling.getTotal_runs() + "\t" + bowling.getTotal_wickets() + "\t"
                        +df.format((bowling.getTotal_runs()/BowlingUtil.getTotalOvers(bowling))));
            }
        }

    }
}
