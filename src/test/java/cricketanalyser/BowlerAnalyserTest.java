package cricketanalyser;

import cricketleagueanalyser.CricketLeagueAnalyser;
import cricketleagueanalyser.CricketLeagueException;
import org.junit.Test;


public class BowlerAnalyserTest {

    private static final String IPL_2019_FACTSHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBowlerByAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int i = cricketLeagueAnalyser.loadBowlerCSVFile(IPL_2019_FACTSHEET_MOST_WKTS);
            System.out.println(i);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
