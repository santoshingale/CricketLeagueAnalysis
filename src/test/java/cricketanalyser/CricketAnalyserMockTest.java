package cricketanalyser;


import cricketleagueanalyser.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.testng.PowerMockTestCase;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CricketAdapterFactory.class)
public class CricketAnalyserMockTest extends PowerMockTestCase {

    private static final String IPL_2019_FACTSHEET_MOST_RUNS = "./src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIPL2019Sheet_shouldReturnRecordsCount() {
        try {
            Map<String, CricketDAO> map = new HashMap<>();
            BatsmanDAO batsmanDAO1 = new BatsmanDAO(37, "Marcus Stoinis", 10, 10, 6, 211, "46", 52.75, 156, 135.25, 0, 0, 14, 10);
            map.put("Marcus Stoinis", new CricketDAO(batsmanDAO1));
            PowerMockito.mockStatic(CricketAdapterFactory.class);
            when(CricketAdapterFactory.getCricketData(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS)).thenReturn(map);
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            System.out.println(listSize);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
