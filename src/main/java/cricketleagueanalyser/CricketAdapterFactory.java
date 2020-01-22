package cricketleagueanalyser;

import java.util.Map;

public class CricketAdapterFactory {
    public static Map<String,CricketDAO> getCricketData(CricketLeagueAnalyser.BatingOrBowling batingOrBowling, String[] csvFilePath) throws CricketLeagueException {
        if (batingOrBowling.equals(CricketLeagueAnalyser.BatingOrBowling.BATING))
            return new BatsmanAdapter().loadCricketData(BatsmanDAO.class, csvFilePath[0]);
        return new BowlerAdapter().loadCricketData(BowlerDAO.class, csvFilePath[0]);
    }
}
