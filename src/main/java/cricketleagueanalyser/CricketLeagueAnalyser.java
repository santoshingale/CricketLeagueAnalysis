package cricketleagueanalyser;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class CricketLeagueAnalyser {

    private HashMap<SortingField, Comparator<BatsmanDAO>> sortField = null;
    List<BatsmanDAO> iplCricketorsRunList = null;

    public CricketLeagueAnalyser() {

        this.sortField = new HashMap<>();
        this.sortField.put(SortingField.AVEREGE, Comparator.comparing(batsmanDAO -> batsmanDAO.avg));
        this.sortField.put(SortingField.STRIKE_RATE, Comparator.comparing(batsmanDAO -> batsmanDAO.strikeRate));
        this.sortField.put(SortingField.MAX_6S_4S, Comparator.comparing(batsmanDAO -> (batsmanDAO.sixes * 6 + batsmanDAO.fours * 4)));
        this.sortField.put(SortingField.MAX_STIKE_6S_4S, sortField.get(SortingField.MAX_6S_4S).thenComparing(batsmanDAO -> batsmanDAO.strikeRate));
        this.sortField.put(SortingField.GREAT_AVEREGE_STRIKE_RATE, sortField.get(SortingField.AVEREGE).thenComparing(batsmanDAO -> batsmanDAO.strikeRate));
        this.sortField.put(SortingField.MAX_RUN, Comparator.comparing(batsmanDAO -> batsmanDAO.runs));
        this.sortField.put(SortingField.MAX_RUN_AVERAGE, sortField.get(SortingField.MAX_RUN).thenComparing(batsmanDAO -> batsmanDAO.avg));
    }

    public int loadCricketCSVFile(String csvFilePath) throws CricketLeagueException {
        iplCricketorsRunList = CricketLeagueAdapter.loadCricketData(csvFilePath);
        return iplCricketorsRunList.size();
    }

    public List<BatsmanDAO> getSortedDataByDESCOrder(SortingField fieldSortingField) {
        iplCricketorsRunList = iplCricketorsRunList.stream()
                .sorted(sortField.get(fieldSortingField))
                .collect(Collectors.toList());
        Collections.reverse(iplCricketorsRunList);
        iplCricketorsRunList.forEach(System.out::println);
        return this.iplCricketorsRunList;
    }
}
