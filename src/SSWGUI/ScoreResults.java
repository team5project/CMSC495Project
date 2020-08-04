package SSWGUI;

public class ScoreResults {
    private final String date;
    private final String homeTeam;
    private final int homeGoals;
    private final String awayTeam;
    private final int awayGoals;
    private final String venue;

    ScoreResults(String date,String homeTeam,int homeGoals,String awayTeam,int awayGoals,String venue){
        this.date = date;
        this.homeTeam = homeTeam;
        this.homeGoals = homeGoals;
        this.awayTeam = awayTeam;
        this.awayGoals = awayGoals;
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public String getVenue() {
        return venue;
    }
}
