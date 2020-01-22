package cricketleagueanalyser;

import java.util.Map;

public class BowlerAdapter extends CricketLeagueAdapter {
    @Override
    public Map<String, CricketDAO> loadCricketData(Class<BatsmanDAO> batsmanDAOClass, String... csvFilePath) throws ClassCastException, CricketLeagueException {
        Map<String, CricketDAO> cricketDAOMap = super.loadCricketData(BatsmanDAO.class, csvFilePath[0]);
        return cricketDAOMap;
    }
}
