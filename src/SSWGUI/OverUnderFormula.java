package SSWGUI;

public class OverUnderFormula {
    // GS = actual goals scored
    // XGP = Expected goals by total passes
    // XGS = Expected goals by total shots taken
    // GA = actual goals allowed
    // XGA = expected goals allowed by total saves
    double homeGS, homeXGP, homeXGS, homeGA, homeXGA, homePasses, homeShots, homeSaves;
    double awayGS, awayXGP, awayXGS, awayGA, awayXGA, awayPasses, awayShots, awaySaves;
    double homeProjection, awayProjection, overUnder; // Expected goals per all of the above metrics

    final double passScoreRate = 336;
    final double shotScoreRate = 9;

    OverUnderFormula(){}

    double OverUnderCalc(double homeGS,double homeGA,double homePasses,double homeShots,double homeSaves,
                            double awayGS,double awayGA,double awayPasses,double awayShots,double awaySaves){
        this.homeGS = homeGS;
        this.homeGA = homeGA;
        this.homePasses = homePasses;
        this.homeShots = homeShots;
        this.homeSaves = homeSaves;
        this.awayGS = awayGS;
        this.awayGA = awayGA;
        this.awayPasses = awayPasses;
        this.awayShots = awayShots;
        this.awaySaves = awaySaves;

        // Calculating home team's projected goals scored
        homeXGP = (homePasses / passScoreRate) / 38;
        homeXGS = (homeShots / shotScoreRate) / 38;
        awayXGA = (awaySaves / 2) / 38; // away goals allowed impacts the home team's chances of scoring goals
        homeProjection = (((homeXGP + homeXGS) / 2) + (homeGS / 38) + (awayGA / 38) + awayXGA) / 4; // division by 4 to weight everything evenly

        // Calculating away team's projected goals scored
        awayXGP = (awayPasses / passScoreRate) / 38;
        awayXGS = (awayShots / shotScoreRate) / 38;
        homeXGA = (homeSaves / 2) / 38; // home goals allowed impacts the away team's chances of scoring goals
        awayProjection = (((awayXGP + awayXGS) / 2) + (awayGS / 38) + (homeGA / 38) + homeXGA) / 4;

        // Calculating final over/under by combining both team's projected scores
        overUnder = Math.floor(homeProjection + awayProjection) + 0.5;
        return overUnder;
    }

}
