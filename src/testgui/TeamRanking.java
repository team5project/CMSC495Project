package testgui;

import java.util.Date;

public class TeamRanking {
    private String team;
    private int ranking,wins,losses,draws,goalsFor,goalsAgainst;

    TeamRanking(String team,int ranking,int wins,int losses,int draws,int goalsFor,int goalsAgainst){
        this.team = team;
        this.ranking = ranking;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;

    }

    public String getTeam() {
        return team;
    }

    public int getRanking() {
        return ranking;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }
}
