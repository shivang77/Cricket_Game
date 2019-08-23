package com.tekion.cricket.controller;

import com.tekion.cricket.beans.Bowling;
import com.tekion.cricket.beans.Player;
import com.tekion.cricket.beans.Team;
import com.tekion.cricket.util.BowlingUtil;
import com.tekion.cricket.util.MatchConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BowlingController {

    /*
     * Update player bowling record after each match
     */
    public static boolean updatePlayerBowlingRecord(Team first_team, Team second_team){
        List<Player> players = new ArrayList<>();
        String query = "";
        ResultSet rs;
        Statement statement;
        try{
            players.addAll(first_team.getPlayers());
            players.addAll(second_team.getPlayers());
            for(Player player:players){
                if(Double.compare(0.0, BowlingUtil.getTotalOvers(player.getBowling())) != 0){
                    query = "SELECT player_id, overs, wickets, maidens, runs FROM "+ MatchConstants.CRICKET_DATABASE + "." + MatchConstants.PLAYER_BOWLING_TABLE
                            + " where player_id = " + player.getPlayerId();
                    statement = CricketController.conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rs = statement.executeQuery(query);
                    rs.next();
                    rs.updateInt("overs", rs.getInt("overs") + (int)BowlingUtil.getTotalOvers(player.getBowling()));
                    rs.updateInt("wickets",rs.getInt("wickets") + player.getBowling().getTotal_wickets());
                    rs.updateInt("maidens", rs.getInt("maidens") + player.getBowling().getTotal_maiden());
                    rs.updateInt("runs", rs.getInt("runs") + player.getBowling().getTotal_runs());
                    rs.updateRow();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /* Add bowling record for particular match
     *
     */
    public static boolean insertMatchBowling(Team first_team, Team second_team, int match_id){
        List<Player> players = new ArrayList<>();
        String query = "INSERT INTO " + MatchConstants.CRICKET_DATABASE + "." + MatchConstants.MATCH_BOWLING_TABLE +
                "(`match_id`, `player_id`, `overs`, `wickets`, `maiden`, `run_given`) VALUES (?,?,?,?,?,?)";
        Bowling bowling;
        try{
            PreparedStatement ps = CricketController.conn.prepareStatement(query);
            players.addAll(first_team.getPlayers());
            players.addAll(second_team.getPlayers());
            for(Player player: players){
                bowling = player.getBowling();
                ps.setInt(1, match_id);
                ps.setInt(2, player.getPlayerId());
                ps.setInt(3, (int)BowlingUtil.getTotalOvers(bowling));
                ps.setInt(4, bowling.getTotal_wickets());
                ps.setInt(5, bowling.getTotal_maiden());
                ps.setInt(6, bowling.getTotal_runs());
                ps.addBatch();
            }
            ps.executeBatch();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     * To get the player bowling record for a particular match
     */
    public static Bowling getPlayerBowlingMatchRecord(int player_id, int match_id){
        Bowling bowling = null;
        String query = "SELECT overs, wickets, maiden, run_given FROM "+ MatchConstants.CRICKET_DATABASE + "." + MatchConstants.MATCH_BOWLING_TABLE
                + " where player_id = " + player_id + " and match_id = " + match_id ;
        try{
            Statement st = CricketController.conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                bowling = new Bowling(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return bowling;
    }

    /*
     * To get the player bowling record till the time
     */
    public static Bowling getPlayerBowlingRecord(int player_id){
        Bowling bowling = null;
        String query = "SELECT overs, wickets, maiden, runs FROM "+ MatchConstants.CRICKET_DATABASE + "." + MatchConstants.PLAYER_BOWLING_TABLE
                + " where player_id = " + player_id;
        try{
            Statement st = CricketController.conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                bowling = new Bowling(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return bowling;
    }
}
