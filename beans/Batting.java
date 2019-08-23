package com.tekion.cricket.beans;

import java.util.List;

public class Batting {

    /*
     * private instance member for a bowler
     */
    private int total_dots = 0;
    private int total_ones = 0;
    private int total_twos = 0;
    private int total_threes = 0;
    private int total_fours = 0;
    private int total_six = 0;
    private int total_runs = 0;
    private int total_balls = 0;

    /*
     * if player is playing then isOut=0 else 1
     */
    private int isOut = 0;

    /*
     * Constructor with all the fields
     */
    public Batting(int total_dots, int total_ones, int total_twos, int total_threes, int total_fours, int total_six, int total_runs, int total_balls, int isOut) {
        this.total_dots = total_dots;
        this.total_ones = total_ones;
        this.total_twos = total_twos;
        this.total_threes = total_threes;
        this.total_fours = total_fours;
        this.total_six = total_six;
        this.total_runs = total_runs;
        this.total_balls = total_balls;
        this.isOut = isOut;
    }

    public Batting(){
    }

    /*
     * Getter methods to get Batsman property
     */
    public int getTotal_dots() {
        return total_dots;
    }

    public int getTotal_ones() {
        return total_ones;
    }

    public int getTotal_twos() {
        return total_twos;
    }

    public int getTotal_threes() {
        return total_threes;
    }

    public int getTotal_fours() {
        return total_fours;
    }

    public int getTotal_six() {
        return total_six;
    }

    public int getTotal_runs() {
        return total_runs;
    }

    public int getTotal_balls() {
        return total_balls;
    }

    public int getIsOut() {
        return isOut;
    }

    /*
     * Setter methods to set Batsman property
     */
    public void setTotal_dots(int total_dots) {
        this.total_dots = total_dots;
    }

    public void setTotal_ones(int total_ones) {
        this.total_ones = total_ones;
    }

    public void setTotal_twos(int total_twos) {
        this.total_twos = total_twos;
    }

    public void setTotal_threes(int total_threes) {
        this.total_threes = total_threes;
    }

    public void setTotal_fours(int total_fours) {
        this.total_fours = total_fours;
    }

    public void setTotal_six(int total_six) {
        this.total_six = total_six;
    }

    public void setTotal_runs(int total_runs) {
        this.total_runs = total_runs;
    }

    public void setTotal_balls(int total_balls) {
        this.total_balls = total_balls;
    }

    public void setIsOut(int isOut) {
        this.isOut = isOut;
    }

    /*
     * Method to print batsman specification
     */
    @Override
    public String toString() {
        return "Batting{" +
                "total_dots=" + total_dots +
                ", total_ones=" + total_ones +
                ", total_twos=" + total_twos +
                ", total_threes=" + total_threes +
                ", total_fours=" + total_fours +
                ", total_six=" + total_six +
                ", total_runs=" + total_runs +
                ", total_balls=" + total_balls +
                ", isOut=" + isOut +
                '}';
    }

}
