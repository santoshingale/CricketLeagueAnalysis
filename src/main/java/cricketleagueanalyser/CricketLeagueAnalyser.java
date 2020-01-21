package cricketleagueanalyser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CricketLeagueAnalyser {

    List<CricketDAO> iplCricketorsRunList = null;
    public enum BatingOrBowling{
        BATING,BAWLING
    }

    public int loadCricketCSVFile(BatingOrBowling batingOrBowling, String csvFilePath) throws CricketLeagueException {
        iplCricketorsRunList = new CricketLeagueAdapter().loadCricketData(csvFilePath,BatsmanDAO.class);
        System.out.println(iplCricketorsRunList.toString());
        return iplCricketorsRunList.size();
    }

    public int loadBowlerCSVFile(BatingOrBowling batingOrBowling, String csvFilePath) throws CricketLeagueException {
        iplCricketorsRunList = new CricketLeagueAdapter().loadCricketData(csvFilePath,BowlerDAO.class);
        return iplCricketorsRunList.size();
    }

    public List getSortedDataByDESCOrder(SortingField.Field fieldSortingField) {
        iplCricketorsRunList = iplCricketorsRunList.stream()
                .sorted(new SortingField().getSortingField(fieldSortingField))
                .collect(Collectors.toList());
        Collections.reverse(iplCricketorsRunList);
        iplCricketorsRunList.forEach(System.out::println);
        return iplCricketorsRunList;
    }
}
