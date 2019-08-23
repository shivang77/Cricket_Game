package com.tekion.cricket.beans;

import com.tekion.cricket.util.TeamName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Team {

    /*
     * private instance field for each Team
     */
    private TeamName teamName;
    private List<Player> players;
    private Player captain;
    private Player vice_captain;

    /*
     * Constructor for Team which takes builder object as parameter
     */
    private Team(Builder builder){
        this.teamName = builder.teamName;
        this.players = builder.players;
        this.captain = builder.captain;
        this.vice_captain = builder.vice_captain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamName == team.teamName &&
                players.equals(team.players) &&
                captain.equals(team.captain) &&
                vice_captain.equals(team.vice_captain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, players, captain, vice_captain);
    }

    /*
     * Method to Team Players Specifications
     */

    @Override
    public String toString() {
        return "Team{" +
                "teamName=" + teamName +
                ", players=" + players +
                ", captain=" + captain +
                ", vice_captain=" + vice_captain +
                '}';
    }
    /*
     * Getter methods to get the Team property
     */

    public TeamName getTeamName() {
        return teamName;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public Player getCaptain() {
        return captain;
    }

    public Player getVice_captain() {
        return vice_captain;
    }

    /*
     * Method to change captain
     */
    public void changeCaptain(Player captain){
        this.captain = captain;
    }

    /*
     * Method to change vice-captain
     */
    public void changeViceCaptain(Player vice_captain){
        this.vice_captain = vice_captain;
    }

    /*
     * static member builder class for Team class instance creation
     */
    public static class Builder{
        private TeamName teamName;
        private List<Player> players;
        private Player captain;
        private Player vice_captain;
        public Builder setTeamName(TeamName teamName) {
            this.teamName = teamName;
            return this;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = new ArrayList<>(players);
            return this;
        }

        public Builder addPlayer(Player player){
            if(players == null){
                players = new ArrayList<>();
            }
            players.add(player);
            return this;
        }

        public Builder setCaptain(Player captain) {
            this.captain = captain;
            return this;
        }

        public Builder setVice_captain(Player vice_captain) {
            this.vice_captain = vice_captain;
            return this;
        }

        public Team build(){
            return new Team(this);
        }
    }

}
