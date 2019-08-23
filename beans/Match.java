package com.tekion.cricket.beans;

import com.tekion.cricket.util.TeamName;
import com.tekion.cricket.util.TossWinChoice;

public class Match {

    /*
     * private instance field for each Match
     */
    private int overs;
    private Team first_team;
    private Team second_team;
    private TeamName toss_won_by;
    private TossWinChoice toss_win_choice;
    private TeamName match_won_by;
    private Team team_batting_first;
    private Team team_balling_first;

    /*
     * Constructor for Match which takes builder object as parameter
     */
    private Match(Builder builder){
        this.overs = builder.overs;
        this.first_team = builder.first_team;
        this.second_team = builder.second_team;
        this.toss_won_by = builder.toss_won_by;
        this.toss_win_choice = builder.toss_win_choice;
        this.match_won_by = builder.match_won_by;

        /*
         * assigning team_batting_first value based on toss and choice of batting or bowling
         */
        if(toss_win_choice == TossWinChoice.BATTING){
            if(first_team.getTeamName() == toss_won_by){
                team_batting_first = first_team;
                team_balling_first = second_team;
            }else{
                team_batting_first = second_team;
                team_balling_first = first_team;
            }
        }else{
            if(first_team.getTeamName() == toss_won_by){
                team_batting_first = second_team;
                team_balling_first = first_team;

            }else{
                team_batting_first = first_team;
                team_balling_first = second_team;
            }
        }
    }

    /*
     * static member builder class for Match class instance creation
     */
    public static class Builder{
        private int overs;
        private Team first_team;
        private Team second_team;
        private TeamName toss_won_by;
        private TossWinChoice toss_win_choice;
        private TeamName match_won_by;

        public Builder setOvers(int overs) {
            this.overs = overs;
            return this;
        }

        public Builder setFirst_team(Team first_team) {
            this.first_team = first_team;
            return this;
        }

        public Builder setSecond_team(Team second_team) {
            this.second_team = second_team;
            return this;
        }

        public Builder setToss_won_by(TeamName toss_won_by) {
            this.toss_won_by = toss_won_by;
            return this;
        }

        public Builder setToss_win_choice(TossWinChoice toss_win_choice) {
            this.toss_win_choice = toss_win_choice;
            return this;
        }
        public Builder setMatch_won_by(TeamName match_won_by) {
            this.match_won_by = match_won_by;
            return this;
        }

        public Match build(){
            return new Match(this);
        }
    }

    /*
     * Method to Print Match Specifications
     */
    @Override
    public String toString() {
        return "Match{" +
                "overs=" + overs +
                ", first_team=" + first_team.getTeamName() +
                ", second_team=" + second_team.getTeamName() +
                ", toss_won_by=" + toss_won_by +
                ", toss_win_choice=" + toss_win_choice +
                ", match_won_by=" + match_won_by +
                '}';
    }

    /*
     * Setter methods to get the Match property
     */
    public void setToss_won_by(TeamName toss_won_by) {
        this.toss_won_by = toss_won_by;
    }

    public void setToss_win_choice(TossWinChoice toss_win_choice) {
        this.toss_win_choice = toss_win_choice;
    }

    public void setMatch_won_by(TeamName match_won_by) {
        this.match_won_by = match_won_by;
    }

    /*
     * Getter methods to get the Match property
     */
    public int getOvers() {
        return overs;
    }

    public Team getFirst_team() {
        return first_team;
    }

    public Team getSecond_team() {
        return second_team;
    }

    public TeamName getToss_won_by() {
        return toss_won_by;
    }

    public TossWinChoice getToss_win_choice() {
        return toss_win_choice;
    }

    public TeamName getMatch_won_by() {
        return match_won_by;
    }

    public Team getTeam_batting_first() {
        return team_batting_first;
    }

    public Team getTeam_balling_first() {
        return team_balling_first;
    }
}
