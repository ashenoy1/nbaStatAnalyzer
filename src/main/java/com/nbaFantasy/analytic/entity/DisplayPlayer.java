package com.nbaFantasy.analytic.entity;

public class DisplayPlayer implements Comparable<DisplayPlayer>{
    private String Player;

    public DisplayPlayer(String player, double fantasyPoint) {
        Player = player;
        this.fantasyPoint = fantasyPoint;
    }

    private double fantasyPoint;

    public String getPlayer() {
        return Player;
    }

    public void setPlayer(String player) {
        Player = player;
    }

    public double getFantasyPoint() {
        return fantasyPoint;
    }

    public void setFantasyPoint(double fantasyPoint) {
        this.fantasyPoint = fantasyPoint;
    }

    @Override
    public int compareTo(DisplayPlayer comparestu) {
        double compareage=((DisplayPlayer)comparestu).getFantasyPoint();
        /* For Ascending order*/
        int diff = (int) (compareage- this.fantasyPoint);
        return diff;
    }
}
