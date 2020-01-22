package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BatsmanAnalyserTest {

    private static final String IPL_2019_FACTSHEET_MOST_RUNS = "./src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIPL2019Sheet_shouldReturnRecordsCount() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            System.out.println(listSize);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBatsmanByAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            List<BatsmanDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.AVEREGE);
            Assert.assertEquals(83.2, topCricketorsAverageScorelist.get(0).avg, 0);
            Assert.assertEquals(0, topCricketorsAverageScorelist.get(99).avg, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBatsmanByStrikingRates() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            List<BatsmanDAO> topCricketorsStrikingRateslist = cricketLeagueAnalyser.getSortedData(SortingField.Field.STRIKE_RATE);
            Assert.assertEquals(333.33, topCricketorsStrikingRateslist.get(0).strikeRate, 0);
            Assert.assertEquals(63.15, topCricketorsStrikingRateslist.get(99).strikeRate, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBatsmanByMaxSixAndFour() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            List<BatsmanDAO> cricketorsSixAndFourWiselist = cricketLeagueAnalyser.getSortedData(SortingField.Field.MAX_6S_4S);
            Assert.assertEquals("Andre Russell", cricketorsSixAndFourWiselist.get(0).player);
            Assert.assertEquals("Shakib Al Hasan", cricketorsSixAndFourWiselist.get(99).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBatsmanByMaxStrikeRateWithSixAndFour() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            List<BatsmanDAO> cricketorsSixAndFourWiselist = cricketLeagueAnalyser.getSortedData(SortingField.Field.MAX_STIKE_6S_4S);
            Assert.assertEquals("Andre Russell", cricketorsSixAndFourWiselist.get(0).player);
            Assert.assertEquals("Shakib Al Hasan", cricketorsSixAndFourWiselist.get(99).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBatsmanByAverageWithStrikeRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            List<BatsmanDAO> cricketorsSixAndFourWiselist = cricketLeagueAnalyser.getSortedData(SortingField.Field.GREAT_AVEREGE_STRIKE_RATE);
            Assert.assertEquals("MS Dhoni", cricketorsSixAndFourWiselist.get(0).player);
            Assert.assertEquals("Tim Southee", cricketorsSixAndFourWiselist.get(99).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBatsmanByMaxRunWithAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            List<BatsmanDAO> cricketorsSixAndFourWiselist = cricketLeagueAnalyser.getSortedData(SortingField.Field.MAX_RUN_AVERAGE);
            Assert.assertEquals("David Warner", cricketorsSixAndFourWiselist.get(0).player);
            Assert.assertEquals("Tim Southee", cricketorsSixAndFourWiselist.get(99).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}