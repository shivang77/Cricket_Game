package com.tekion.cricket.controller;

import com.tekion.cricket.beans.Player;
import com.tekion.cricket.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamController {

    /*
     * To fetch the team name from the database based on team_id
     */
    public static TeamName getTeamName(int team_id){
        String query = "SELECT team_name FROM "+ MatchConstants.CRICKET_DATABASE + "." + MatchConstants.TEAM_TABLE
                + " where team_id = " + team_id;
        String teamName = "";
        try{
            Statement st = CricketController.conn.createStatement();
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                teamName = rs.getString(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return CricketUtil.getTeamName(teamName.toLowerCase());
    }

    /*
     * To get all the players of the team with team_id and team name
     */
    public static List<Player> getPlayers(int team_id, TeamName teamName){
        List<Player> players = new ArrayList<>();
        String query = "SELECT player_id, player_name, player_role FROM "+ MatchConstants.CRICKET_DATABASE + "." + MatchConstants.PLAYER_TABLE
                + " where team_id = " + team_id + " ORDER BY player_id";

        int player_id;
        String player_name;
        Role role;
        BowlingStyle bowlingStyle = BowlingStyle.NONE;

        try{
            Statement st = CricketController.conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                player_id = rs.getInt(1);
                player_name = rs.getString(2);
                role = CricketUtil.getRole(rs.getString(3).toLowerCase());
                if(role == Role.BOWLER){
                    bowlingStyle = BowlingStyle.RIGHT_HANDED_FAST_MEDIUM;
                }else if(role == Role.BOWLING_ALLROUNDER){
                    bowlingStyle = BowlingStyle.RIGHT_HANDED_FAST_MEDIUM;
                }
                players.add(new Player.Builder().setPlayerId(player_id).setName(player_name).setRole(role).
                        setTeamName(teamName).setBowling_style(bowlingStyle).build());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return players;
    }
}
