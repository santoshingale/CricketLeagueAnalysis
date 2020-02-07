package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.testng.PowerMockTestCase;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CricketAdapterFactory.class)
public class CricketAnalyserMockTest extends PowerMockTestCase {

    private static final String IPL_2019_FACTSHEET_MOST_RUNS = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    static Map<String, CricketDAO> map = new HashMap<>();

    @Before
    public void setUp() {

        BatsmanDAO batsmanDAO1 = new BatsmanDAO(37, "Marcus Stoinis", 10, 10, 6, 211, "46", 52.60, 156, 135.25, 0, 0, 14, 10);
        BatsmanDAO batsmanDAO2 = new BatsmanDAO(1, "David Warner", 12, 12, 2, 692, "100*", 69.2, 481, 143.86, 1, 8, 57, 21);
        map.put("Marcus Stoinis", new CricketDAO(batsmanDAO1));
        map.put("David Warner", new CricketDAO(batsmanDAO2));
        PowerMockito.mockStatic(CricketAdapterFactory.class);
        try {
            when(CricketAdapterFactory.getCricketData(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS)).thenReturn(map);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnRecordsCount() {
        try {
            System.out.println(map.values());
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int listSize = cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            Assert.assertEquals(2, listSize);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019Sheet_shouldReturnListOfBatsmanByAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadCricketFile(CricketLeagueAnalyser.BatingOrBowling.BATING, IPL_2019_FACTSHEET_MOST_RUNS);
            List<BatsmanDAO> topCricketorsAverageScorelist = cricketLeagueAnalyser.getSortedData(SortingField.Field.BATING_AVEREGE);
            Assert.assertEquals(69.2, topCricketorsAverageScorelist.get(0).batingAverage, 0);
            Assert.assertEquals(52.6, topCricketorsAverageScorelist.get(1).batingAverage, 0);
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
            Assert.assertEquals(143.86, topCricketorsStrikingRateslist.get(0).strikeRate, 0);
            Assert.assertEquals(135.25, topCricketorsStrikingRateslist.get(1).strikeRate, 0);
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
            Assert.assertEquals("David Warner", cricketorsSixAndFourWiselist.get(0).player);
            Assert.assertEquals("Marcus Stoinis", cricketorsSixAndFourWiselist.get(1).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
