package com.tekion.cricket.controller;

import com.tekion.cricket.beans.Batting;
import com.tekion.cricket.beans.Player;
import com.tekion.cricket.beans.Team;
import com.tekion.cricket.util.MatchConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattingController {

    /*
     * Update player batting record after each  match
     */
    public static boolean updatePlayerBattingRecord(Team first_team, Team second_team){
        List<Player> players = new ArrayList<>();
        String query = "";
        ResultSet rs;
        Statement statement;
        int strike_rate = 0;
        try{
            players.addAll(first_team.getPlayers());
            players.addAll(second_team.getPlayers());
            for(Player player:players){
                query = "SELECT player_id, matches, runs, fours, sixes , hundreds, fifties, strike_rate FROM "+ MatchConstants.CRICKET_DATABASE +
                        "." + MatchConstants.PLAYER_BATTING_TABLE + " where player_id = " + player.getPlayerId();
                statement = CricketController.conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = statement.executeQuery(query);
                rs.next();
                rs.updateInt("matches", rs.getInt("matches")+1);
                rs.updateInt("runs",rs.getInt("runs")+player.getBatting().getTotal_runs());
                rs.updateInt("fours", rs.getInt("fours") + player.getBatting().getTotal_fours());
                rs.updateInt("sixes", rs.getInt("sixes") + player.getBatting().getTotal_six());

                if(player.getBatting().getTotal_runs() >= 100){
                    rs.updateInt("hundreds", rs.getInt("hundreds")+1);
                }else if(player.getBatting().getTotal_runs() >= 50){
                    rs.updateInt("fifties", rs.getInt("fifties")+1);
                }

                if(player.getBatting().getIsOut() == 0){
                    if(rs.getInt("matches") == 0){
                        strike_rate = player.getBatting().getTotal_runs();
                    }else{
                        strike_rate = (rs.getInt("runs") + player.getBatting().getTotal_runs()) / rs.getInt("matches");
                    }
                }else{
                    strike_rate = (rs.getInt("runs") + player.getBatting().getTotal_runs()) / (rs.getInt("matches") + 1);
                }
                rs.updateDouble("strike_rate", strike_rate);
                rs.updateRow();
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     * Add batting record for particular match
     */
    public static boolean insertMatchBatting(Team first_team, Team second_team, int match_id){
        List<Player> players = new ArrayList<>();
        String query = "INSERT INTO " + MatchConstants.CRICKET_DATABASE + "." + MatchConstants.MATCH_BATTING_TABLE +
                "(`match_id`, `player_id`, `score`, `ball_played`, `fours`, `six`, `is_out`) VALUES (?,?,?,?,?,?,?)";
        Batting batting;
        try{
            PreparedStatement ps = CricketController.conn.prepareStatement(query);
            players.addAll(first_team.getPlayers());
            players.addAll(second_team.getPlayers());
            for(Player player: players){
                batting = player.getBatting();
                ps.setInt(1, match_id);
                ps.setInt(2, player.getPlayerId());
                ps.setInt(3, batting.getTotal_runs());
                ps.setInt(4, batting.getTotal_balls());
                ps.setInt(5, batting.getTotal_fours());
                ps.setInt(6, batting.getTotal_six());
                ps.setInt(7, batting.getIsOut());
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
     * To get the player batting record for a particular match
     */
    public static Batting getPlayerBattingMatchRecord(int player_id, int match_id){
        Batting batting = null;
        String query = "SELECT score, ball_played, fours, six , is_out FROM "+ MatchConstants.CRICKET_DATABASE + "." + MatchConstants.MATCH_BATTING_TABLE
                + " where player_id = " + player_id + " and match_id = " + match_id ;
        try{
            Statement st = CricketController.conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                batting = new Batting(0, 0, 0, 0, rs.getInt(3),
                        rs.getInt(4), rs.getInt(1), rs.getInt(2), rs.getInt(5));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return batting;
    }

    /*
     * To get the player batting record till the time
     */
    public static Map<String, Double> getPlayerBattingRecord(int player_id){
        Map<String, Double> batting = new HashMap<>();
        String query = "SELECT matches, runs, fours, sixes , hundreds, fifties, strike_rate FROM "+ MatchConstants.CRICKET_DATABASE +
                "." + MatchConstants.PLAYER_BATTING_TABLE + " where player_id = " + player_id;
        try{
            Statement st = CricketController.conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                batting.put("player_id", Double.valueOf(player_id));
                batting.put("matches", rs.getDouble(1));
                batting.put("runs", rs.getDouble(2));
                batting.put("fours", rs.getDouble(3));
                batting.put("sixes", rs.getDouble(4));
                batting.put("hundreds", rs.getDouble(5));
                batting.put("fifties", rs.getDouble(6));
                batting.put("strike_rate", rs.getDouble(7));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return batting;
    }
}
