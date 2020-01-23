package cricketleagueanalyser;

import java.util.Map;

public class BowlerAdapter extends CricketLeagueAdapter {
    @Override
    public Map<String, CricketDAO> loadCricketData(String... csvFilePath) throws ClassCastException, CricketLeagueException {
        Map<String, CricketDAO> cricketDAOMap = super.loadCricketData(BowlerDAO.class, csvFilePath[0]);
        return cricketDAOMap;
    }
}
