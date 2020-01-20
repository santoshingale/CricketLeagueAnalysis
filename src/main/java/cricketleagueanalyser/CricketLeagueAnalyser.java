package cricketleagueanalyser;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class CricketLeagueAnalyser {

    List<BatsmanDAO> iplCricketorsRunList = null;

    public int loadCricketCSVFile(String csvFilePath) throws CricketLeagueException {
        iplCricketorsRunList = CricketLeagueAdapter.loadCricketData(csvFilePath);
        return iplCricketorsRunList.size();
    }

    public int loadBowlerCSVFile(String csvFilePath) throws CricketLeagueException {
        iplCricketorsRunList = CricketLeagueAdapter.loadCricketData(csvFilePath);
        return iplCricketorsRunList.size();
    }

    public List<BatsmanDAO> getSortedDataByDESCOrder(SortingField.Field fieldSortingField) {
        iplCricketorsRunList = iplCricketorsRunList.stream()
                .sorted(new SortingField().getSortingField(fieldSortingField))
                .collect(Collectors.toList());
        Collections.reverse(iplCricketorsRunList);
        iplCricketorsRunList.forEach(System.out::println);
        return this.iplCricketorsRunList;
    }
}
