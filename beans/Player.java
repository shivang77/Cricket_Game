package com.tekion.cricket.beans;

import com.tekion.cricket.util.BattingStyle;
import com.tekion.cricket.util.BowlingStyle;
import com.tekion.cricket.util.Role;
import com.tekion.cricket.util.TeamName;

public class Player{

    /*
     * private instance field for each Player
     */
    private int player_id;
    private String name;
    private int age;
    private Role role;
    private BattingStyle batting_style;
    private BowlingStyle bowling_style;
    private TeamName teamName;
    private Batting batting;
    private Bowling bowling;

    /*
     * Constructor for Player which takes builder object as parameter
     */
    private Player(Builder builder){
        this.player_id = builder.player_id;
        this.name = builder.name;
        this.age = builder.age;
        this.role = builder.role;
        this.batting_style = builder.batting_style;
        this.bowling_style = builder.bowling_style;
        this.teamName = builder.teamName;
        batting = new Batting();
        bowling = new Bowling();
    }

    /*
     * static member builder class for Player class instance creation
     */
    public static class Builder{
        int player_id;
        String name;
        int age = 25;
        Role role;
        BattingStyle batting_style = BattingStyle.RIGHT_HANDED;
        BowlingStyle bowling_style = BowlingStyle.NONE;
        TeamName teamName;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPlayerId(int player_id){
            this.player_id = player_id;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setBatting_style(BattingStyle batting_style) {
            this.batting_style = batting_style;
            return this;
        }

        public Builder setBowling_style(BowlingStyle bowling_style) {
            this.bowling_style = bowling_style;
            return this;
        }

        public Builder setTeamName(TeamName teamName) {
            this.teamName = teamName;
            return this;
        }

        public Player build(){
            return new Player(this);
        }

    }

    /*
     * Method to Print Players Specifications
     */
    @Override
    public String toString() {
        return "Player{" +
                "id=" + player_id  +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", role=" + role +
                ", batting_style=" + batting_style +
                ", bowling_style=" + bowling_style +
                ", teamName=" + teamName +
                '}';
    }

    /*
     * Setter methods to set the players property
     */
    public void setBowling(Bowling bowling) {
        Bowling temp_bowling = bowling;
        this.bowling = temp_bowling;
    }

    public void setBatting(Batting batting) {
        Batting temp_batting = batting;
        this.batting = temp_batting;
    }

    /*
     * Getter methods to get the players property
     */
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    public BattingStyle getBatting_style() {
        return batting_style;
    }

    public BowlingStyle getBowling_style() {
        return bowling_style;
    }

    public TeamName getTeamName() {
        return teamName;
    }

    public Batting getBatting() {
        return batting;
    }

    public Bowling getBowling() {
        return bowling;
    }

    public int getPlayerId(){
        return player_id;
    }
}
