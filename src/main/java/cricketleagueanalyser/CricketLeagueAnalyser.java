package cricketleagueanalyser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CricketLeagueAnalyser {

    private BatingOrBowling batingOrBowling;

    List<CricketDAO> iplCricketorsRunList = null;
    public enum BatingOrBowling{
        BATING,BAWLING
    }

    public int loadCricketFile(BatingOrBowling batingOrBowling, String csvFilePath) throws CricketLeagueException {
        this.batingOrBowling = batingOrBowling;
        iplCricketorsRunList = CricketAdapterFactory.getCricketData(batingOrBowling,csvFilePath);
        return iplCricketorsRunList.size();
    }


    public List getSortedData(SortingField.Field fieldSortingField) {
        List iplCricketorsList = iplCricketorsRunList.stream()
                .sorted(new SortingField().getSortingField(fieldSortingField))
                .map(cricketDAO -> cricketDAO.getCensusDTO(batingOrBowling))
                .collect(Collectors.toList());
        Collections.reverse(iplCricketorsList);
        iplCricketorsList.forEach(System.out::println);
        return iplCricketorsList;
    }
}
