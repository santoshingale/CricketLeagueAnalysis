package cricketanalyser;

import cricketleagueanalyser.CricketLeagueAnalyser;
import org.junit.Test;

public class cricketAnalyser {

    private static final String IPL_2019_FACTSHEET_MOST_RUNS = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_FACTSHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPL2019Sheet_shouldReturnAverageOfCricketorsWhoPlayedIPL2019() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadCricketCSVFile(IPL_2019_FACTSHEET_MOST_RUNS);
    }
}