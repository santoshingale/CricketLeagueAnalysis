package cricketleagueanalyser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CricketLeagueAnalyser {

    List<CricketDAO> iplCricketorsRunList = null;
    public enum BatingOrBowling{
        BATING,BAWLING
    }

    public int loadCricketFile(BatingOrBowling batingOrBowling, String csvFilePath) throws CricketLeagueException {
        iplCricketorsRunList = CricketAdapterFactory.getCricketData(batingOrBowling,csvFilePath);
        return iplCricketorsRunList.size();
    }


    public List getSortedData(SortingField.Field fieldSortingField) {
        iplCricketorsRunList = iplCricketorsRunList.stream()
                .sorted(new SortingField().getSortingField(fieldSortingField))
                .collect(Collectors.toList());
        Collections.reverse(iplCricketorsRunList);
        iplCricketorsRunList.forEach(System.out::println);
        return iplCricketorsRunList;
    }
}
