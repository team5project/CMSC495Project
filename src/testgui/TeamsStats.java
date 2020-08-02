package testgui;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<TeamsStats> getStats(){
        ArrayList<TeamsStats> data = new ArrayList<>();
        try{
            PreparedStatement statement = (PreparedStatement) conn.dbConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                                                  ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT *  FROM team_stats");
            TeamsStats team1; TeamsStats team2;
            while (rs.next()){
                // Liverpool
                rs.absolute(1);
                team1 = new TeamsStats(rs.getString("team"), rs.getDouble("goals_scored"),
                                       rs.getDouble("goals_allowed"),rs.getDouble("passes"),
                                       rs.getDouble("shots"),rs.getDouble("saves"));
                // Manchester City
                rs.absolute(2);
                team2 = new TeamsStats(rs.getString("team"), rs.getDouble("goals_scored"),
                        rs.getDouble("goals_allowed"),rs.getDouble("passes"),
                        rs.getDouble("shots"),rs.getDouble("saves"));


                data.add(team1);
                data.add(team2);


            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return data;

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
