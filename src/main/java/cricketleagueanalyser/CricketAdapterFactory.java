package cricketleagueanalyser;

import java.util.List;

public class CricketAdapterFactory {
    public static List<CricketDAO> getCricketData(CricketLeagueAnalyser.BatingOrBowling batingOrBowling, String csvFilePath) throws CricketLeagueException {
        if (batingOrBowling.equals(CricketLeagueAnalyser.BatingOrBowling.BATING))
            return new CricketLeagueAdapter().loadCricketData(csvFilePath, BatsmanDAO.class);
        return new CricketLeagueAdapter().loadCricketData(csvFilePath, BowlerDAO.class);
    }
}
