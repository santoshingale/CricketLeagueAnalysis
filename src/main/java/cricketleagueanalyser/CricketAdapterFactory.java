package cricketleagueanalyser;

import java.util.Map;

public class CricketAdapterFactory {
    public static Map<String,CricketDAO> getCricketData(CricketLeagueAnalyser.BatingOrBowling batingOrBowling, String... csvFilePath) throws CricketLeagueException {
        if (batingOrBowling.equals(CricketLeagueAnalyser.BatingOrBowling.BATING))
            return new BatsmanAdapter().loadCricketData(csvFilePath);
        return new BowlerAdapter().loadCricketData(csvFilePath);
    }
}
