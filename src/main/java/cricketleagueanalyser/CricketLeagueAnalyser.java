package cricketleagueanalyser;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    private BatingOrBowling batingOrBowling;

    public Map<String, CricketDAO> iplCricketorsMAP = new HashMap<>();

    public enum BatingOrBowling {
        BATING, BAWLING
    }

    public int loadCricketFile(BatingOrBowling batingOrBowling, String ... csvFilePath) throws CricketLeagueException {
        this.batingOrBowling = batingOrBowling;
        iplCricketorsMAP = CricketAdapterFactory.getCricketData(batingOrBowling, csvFilePath);
        return iplCricketorsMAP.size();
    }

    public List getSortedData(SortingField.Field fieldSortingField) {
        List iplCricketorsList = iplCricketorsMAP.values().stream()
                .sorted(new SortingField().getSortingField(fieldSortingField))
                .map(cricketDAO -> cricketDAO.getCensusDTO(batingOrBowling))
                .collect(Collectors.toList());
        Collections.reverse(iplCricketorsList);
        iplCricketorsList.forEach(System.out::println);
        return iplCricketorsList;
    }
}
