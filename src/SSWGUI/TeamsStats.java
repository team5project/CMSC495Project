package SSWGUI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
Class for team stats to calculate over under
 */
public class TeamsStats {
    private String team;
    private double goalsScored;
    private double goalsAllowed;
    private double passes;
    private double shots;
    private double saves;
    AWSConnection conn;
    PreparedStatement ps;
    ResultSet rs;
    TeamsStats(){}

    TeamsStats(String team, double goalsScored,double goalsAllowed,double passes,
               double shots,double saves){
        this.team = team;
        this.goalsScored = goalsScored;
        this.goalsAllowed = goalsAllowed;
        this.passes = passes;
        this.shots = shots;
        this.saves = saves;
    }



    public double getGoalsScored() {
        return goalsScored;
    }

    public double getGoalsAllowed() {
        return goalsAllowed;
    }

    public double getPasses() {
        return passes;
    }

    public double getShots() {
        return shots;
    }

    public double getSaves() {
        return saves;
    }
}
