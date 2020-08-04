package SSWGUI;

public class UpcomingGames {
    private final String date;
    private final String homeTeam;
    private final String awayTeam;

    UpcomingGames(String date,String homeTeam,String awayTeam){
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public String getDate() {
        return date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }
}
