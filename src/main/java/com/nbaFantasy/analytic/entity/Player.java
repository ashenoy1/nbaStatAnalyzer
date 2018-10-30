package com.nbaFantasy.analytic.entity;

public class Player {
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public boolean isOnCourt() {
        return isOnCourt;
    }

    public void setOnCourt(boolean onCourt) {
        isOnCourt = onCourt;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getFgm() {
        return fgm;
    }

    public void setFgm(String fgm) {
        this.fgm = fgm;
    }

    public String getFga() {
        return fga;
    }

    public void setFga(String fga) {
        this.fga = fga;
    }

    public String getFgp() {
        return fgp;
    }

    public void setFgp(String fgp) {
        this.fgp = fgp;
    }

    public String getFtm() {
        return ftm;
    }

    public void setFtm(String ftm) {
        this.ftm = ftm;
    }

    public String getFta() {
        return fta;
    }

    public void setFta(String fta) {
        this.fta = fta;
    }

    public String getFtp() {
        return ftp;
    }

    public void setFtp(String ftp) {
        this.ftp = ftp;
    }

    public String getTpm() {
        return tpm;
    }

    public void setTpm(String tpm) {
        this.tpm = tpm;
    }

    public String getTpa() {
        return tpa;
    }

    public void setTpa(String tpa) {
        this.tpa = tpa;
    }

    public String getTpp() {
        return tpp;
    }

    public void setTpp(String tpp) {
        this.tpp = tpp;
    }

    public String getOffReb() {
        return offReb;
    }

    public void setOffReb(String offReb) {
        this.offReb = offReb;
    }

    public String getDefReb() {
        return defReb;
    }

    public void setDefReb(String defReb) {
        this.defReb = defReb;
    }

    public String getTotReb() {
        return totReb;
    }

    public void setTotReb(String totReb) {
        this.totReb = totReb;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getpFouls() {
        return pFouls;
    }

    public void setpFouls(String pFouls) {
        this.pFouls = pFouls;
    }

    public String getSteals() {
        return steals;
    }

    public void setSteals(String steals) {
        this.steals = steals;
    }

    public String getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(String turnovers) {
        this.turnovers = turnovers;
    }

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public String getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(String plusMinus) {
        this.plusMinus = plusMinus;
    }

    private String personId;
    private String teamId;
    private boolean isOnCourt;
    private String points;
    private String pos;
    private String min;
    private String fgm;
    private String fga;
    private String fgp;
    private String ftm;
    private String fta;
    private String ftp;
    private String tpm;
    private String tpa;
    private String tpp;
    private String offReb;
    private String defReb;
    private String totReb;
    private String assists;
    private String pFouls;
    private String steals;
    private String turnovers;
    private String blocks;
    private String plusMinus;

    public float getFANTASYSCORE() {
       float fieldGoal = Float.parsefloat(this.fgm);
       float threePtr = Float.parsefloat(this.tpm);
       float rebounds = Float.parsefloat(this.totReb) * 1.5;
       float assistsPts = Float.parsefloat(this.assists) * 1.5;
       float stealsPts = Float.parsefloat(this.seals) * 2.0;
       float blockPts = Float.parsefloat(this.blocks) * 2.0;
       float turnoverPts = Float.parsefloat(this.turnovers) * -1.0;
       float totalFpts = fieldGoal + threePtr + rebounds + assistsPts + stealsPts + blockPts + turnoverPts;


       //NEED TO FIGURE THIS OUT
       if(Float.parsefloat(this.assists) >= 10 && Float.parsefloat(this.assists) >= 10 && Float.parsefloat(this.assists) >= 10)

    }
}
