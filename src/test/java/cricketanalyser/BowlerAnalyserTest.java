package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class BowlerAnalyserTest {

    private static final String IPL_2019_FACTSHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPL2019Sheet_shouldReturnListSize() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BAWLING, IPL_2019_FACTSHEET_MOST_WKTS);
            Assert.assertEquals(99, listSize);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BAWLING, IPL_2019_FACTSHEET_MOST_WKTS);
            List<BowlerDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.BOWLING_AVERAGE);
            Assert.assertEquals("Krishnappa Gowtham", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Suresh Raina", topCricketorsAverageScorelist.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByStrikeRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BAWLING, IPL_2019_FACTSHEET_MOST_WKTS);
            List<BowlerDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.STRIKE_RATE);
            Assert.assertEquals("Krishnappa Gowtham", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Suresh Raina", topCricketorsAverageScorelist.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByEconomyRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BAWLING, IPL_2019_FACTSHEET_MOST_WKTS);
            List<BowlerDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.ECONOMY_RATE);
            Assert.assertEquals("Ben Cutting", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Shivam Dube", topCricketorsAverageScorelist.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByStrikeRateAnd4W5W() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BAWLING, IPL_2019_FACTSHEET_MOST_WKTS);
            List<BowlerDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.MAX_STRIKE_4W_5W);
            Assert.assertEquals("Lasith Malinga", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Suresh Raina", topCricketorsAverageScorelist.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByGreatBowlingAverageAndStrikeRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BAWLING, IPL_2019_FACTSHEET_MOST_WKTS);
            List<BowlerDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.GREAT_AVEREGE_STRIKE_RATE);
            Assert.assertEquals("Krishnappa Gowtham", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Suresh Raina", topCricketorsAverageScorelist.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByWicketsAndAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BAWLING, IPL_2019_FACTSHEET_MOST_WKTS);
            List<BowlerDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.WICKET_AVERAGE);
            Assert.assertEquals("Imran Tahir", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Suresh Raina", topCricketorsAverageScorelist.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
