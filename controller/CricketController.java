package com.tekion.cricket.controller;

import com.tekion.cricket.beans.*;
import com.tekion.cricket.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CricketController {

    static Connection conn;

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(MatchConstants.CONNECTION_URL, MatchConstants.USERNAME, MatchConstants.PASSWORD);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    /*
     * Returns the connection object
     */
    public static Connection getConnection(){
        return  conn;
    }

    /*
     * To get the series details
     */
    public static Map<String, String> getSeriesDetails(int series_id){
        Map<String, String> series = new HashMap<>();
        String query = "SELECT series_name, team1_id, team2_id FROM "+ MatchConstants.CRICKET_DATABASE +
                "." + MatchConstants.SERIES_TABLE + " where series_id = " + series_id;
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                series.put("series_id", Integer.toString(series_id));
                series.put("series_name", rs.getString(1));
                series.put("first_team_id", Integer.toString(rs.getInt(2)));
                series.put("second_team_id", Integer.toString(rs.getInt(3)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return series;
    }


}
