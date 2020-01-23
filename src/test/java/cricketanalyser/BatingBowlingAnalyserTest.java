package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class BatingBowlingAnalyserTest {

    private static final String IPL_2019_FACTSHEET_MOST_RUNS = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_FACTSHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenBatsmanBowlerAheet_shouldReturnListByBatsmanAndBowlerAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS,IPL_2019_FACTSHEET_MOST_WKTS);
            List<BatsmanDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.BATING_BOWLING_AVERAGE);
            Assert.assertEquals("MS Dhoni", topCricketorsAverageScorelist.get(0).player);
            Assert.assertEquals("Harpreet Brar", topCricketorsAverageScorelist.get(99).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
