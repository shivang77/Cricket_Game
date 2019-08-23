package com.tekion.cricket.controller;

import com.tekion.cricket.beans.Player;
import com.tekion.cricket.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    /*
     * To get the record of a player for a particular match
     */
    public static Player getPlayerMatchRecord(int player_id, int match_id){
        Player player = getPlayer(player_id);
        player.setBatting(BattingController.getPlayerBattingMatchRecord(player_id, match_id));
        player.setBowling(BowlingController.getPlayerBowlingMatchRecord(player_id, match_id));
        return player;
    }

    /*
     * To get the player with player id
     */
    public static Player getPlayer(int player_id){
        Player player = null;
        String query = "SELECT player_name, player_role, team_id FROM "+ MatchConstants.CRICKET_DATABASE + "." + MatchConstants.PLAYER_TABLE
                + " where player_id = " + player_id;

        BowlingStyle bowlingStyle = BowlingStyle.NONE;
        Role role;
        try{
            Statement st = CricketController.conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                role = CricketUtil.getRole(rs.getString(2).toLowerCase());
                if(role == Role.BOWLER){
                    bowlingStyle = BowlingStyle.RIGHT_HANDED_FAST_MEDIUM;
                }else if(role == Role.BOWLING_ALLROUNDER){
                    bowlingStyle = BowlingStyle.RIGHT_HANDED_FAST_MEDIUM;
                }
                player = new Player.Builder().setPlayerId(player_id).setName(rs.getString(1)).setBowling_style(bowlingStyle)
                        .setRole(role).setTeamName(TeamController.getTeamName(rs.getInt(3))).setPlayerId(player_id).build();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return player;
    }

}
