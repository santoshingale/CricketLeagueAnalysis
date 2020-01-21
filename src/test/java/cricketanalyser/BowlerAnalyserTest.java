package cricketanalyser;

import cricketleagueanalyser.CricketDAO;
import cricketleagueanalyser.CricketLeagueAnalyser;
import cricketleagueanalyser.CricketLeagueException;
import cricketleagueanalyser.SortingField;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class BowlerAnalyserTest {

    private static final String IPL_2019_FACTSHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    @Test
    public void givenIPL2019Sheet_shouldReturnListSize() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadBowlerCSVFile(IPL_2019_FACTSHEET_MOST_WKTS);
            Assert.assertEquals(99, listSize);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadBowlerCSVFile(IPL_2019_FACTSHEET_MOST_WKTS);
            List<CricketDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedDataByDESCOrder(SortingField.Field.AVEREGE);
            Assert.assertEquals("Krishnappa Gowtham", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Shivam Dube", topCricketorsAverageScorelist.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByStrikeRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadBowlerCSVFile(IPL_2019_FACTSHEET_MOST_WKTS);
            List<CricketDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedDataByDESCOrder(SortingField.Field.STRIKE_RATE);
            Assert.assertEquals("Krishnappa Gowtham", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Shivam Dube", topCricketorsAverageScorelist.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
