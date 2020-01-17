package cricketanalyser;

import cricketleagueanalyser.CricketLeagueAnalyser;
import cricketleagueanalyser.CricketLeagueException;
import cricketleagueanalyser.IPLRunsCSV;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class cricketAnalyser {

    private static final String IPL_2019_FACTSHEET_MOST_RUNS = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_FACTSHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPL2019Sheet_shouldReturnRecordsCount() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketCSVFile(IPL_2019_FACTSHEET_MOST_RUNS);
            Assert.assertEquals(100, listSize);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnAverageOfCricketorsWhoPlayedIPL2019() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketCSVFile(IPL_2019_FACTSHEET_MOST_RUNS);
            List<IPLRunsCSV> topCricketorsAverageScorelist = cricketLeagueAnalyser.getTopCricketorsAverageScore();
            Assert.assertEquals(83.2, topCricketorsAverageScorelist.get(0).avg, 0);
            Assert.assertEquals(0, topCricketorsAverageScorelist.get(99).avg, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnStrikingRatesOfCricketorsWhoPlayedIPL2019() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketCSVFile(IPL_2019_FACTSHEET_MOST_RUNS);
            List<IPLRunsCSV> topCricketorsStrikingRateslist = cricketLeagueAnalyser.getTopCricketorsStrikingRates();
            Assert.assertEquals(333.33, topCricketorsStrikingRateslist.get(0).strikeRate, 0);
            Assert.assertEquals(63.15, topCricketorsStrikingRateslist.get(99).strikeRate, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}