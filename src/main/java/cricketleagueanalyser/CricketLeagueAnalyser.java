package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        this.sortField.put(SortingField.AVEREGE, Comparator.comparing(result -> result.avg));
        this.sortField.put(SortingField.STIKE_RATE, Comparator.comparing(result -> result.strikeRate));
        this.sortField.put(SortingField.MAX_6S_4S, Comparator.comparing(result -> (result.sixes * 6 + result.fours * 4)));
       // this.sortField.put(SortingField.MAX_STIKE_6S_4S, Comparator.comparing(result -> (result.sixes * 6 + result.fours * 4)).thenComparing(BatsmanDAO :: getStrikeRate));
    }

    public int loadCricketCSVFile(String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplCricketorsRunList = csvBuilder.getListCSVFile(reader, BatsmanDAO.class);
            return iplCricketorsRunList.size();
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.INCORRECT_FILE_DATA);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return 0;
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
