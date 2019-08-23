package com.tekion.cricket.controller;

import com.tekion.cricket.beans.Match;
import com.tekion.cricket.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MatchController {

    /*
     * private constructor to make class not instantiable
     */
    private MatchController(){
    }

    /*
     * Get the max match_id
     */
    public static int getMaxMatchId(){
        String query = "SELECT MAX(match_id) FROM " + MatchConstants.CRICKET_DATABASE + "." + MatchConstants.MATCH_TABLE;
        int match_id = 0;
        try{
            PreparedStatement prep = CricketController.getConnection().prepareStatement(query);
            ResultSet rs = prep.executeQuery();
            while (rs.next()){
                match_id = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return match_id;
    }


    /*
     * Update the database after each match
     */
    public static boolean insertMatchRecords(Match match, int series_id, int match_id){
        String query = "INSERT INTO " + MatchConstants.CRICKET_DATABASE + "." + MatchConstants.MATCH_TABLE +
                " (`match_id`,`series_id`, `toss_won_by`, `match_won_by`, `overs`) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = CricketController.conn.prepareStatement(query);
            ps.setInt(1, match_id);
            ps.setInt(2, series_id);
            ps.setString(3, match.getToss_won_by().toString());
            ps.setString(4, match.getMatch_won_by().toString());
            ps.setInt(5, match.getOvers());
            ps.executeUpdate();
            BattingController.insertMatchBatting(match.getFirst_team(), match.getSecond_team(),match_id);
            BowlingController.insertMatchBowling(match.getFirst_team(), match.getSecond_team(),match_id);
            BattingController.updatePlayerBattingRecord(match.getFirst_team(), match.getSecond_team());
            BowlingController.updatePlayerBowlingRecord(match.getFirst_team(), match.getSecond_team());
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     * To get the match details
     */
    public static Map<String, String> getMatchDetails(int match_id){
        Map<String, String> match = new HashMap<>();
        String query = "SELECT series_id, toss_won_by , match_won_by, overs FROM "+ MatchConstants.CRICKET_DATABASE +
                "." + MatchConstants.MATCH_TABLE + " where match_id = " + match_id;
        try{
            Statement st = CricketController.conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                match.put("match_id", Integer.toString(match_id));
                match.put("series_id", Integer.toString(rs.getInt(1)));
                match.put("toss_won_by", rs.getString(2));
                match.put("match_won_by", rs.getString(3));
                match.put("overs", Integer.toString(rs.getInt(4)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return match;
    }
}
