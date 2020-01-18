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

    private HashMap<String, Comparator<IPLRunsCSV>> sortField = null;
    List<IPLRunsCSV> iplCricketorsRunList = null;

    public CricketLeagueAnalyser() {

        this.sortField = new HashMap<>();
        this.sortField.put("average", Comparator.comparing(result -> result.avg));
        this.sortField.put("strikeRate", Comparator.comparing(result -> result.strikeRate));
        this.sortField.put("max4s6s", Comparator.comparing(result -> (result.sixes * 6 + result.fours * 4 )));
       /* this.sortField.put("strikeWith4s6s");
        this.sortField.put("greatAvgWithstrikeRate",)*/
    }

    public int loadCricketCSVFile(String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplCricketorsRunList = csvBuilder.getListCSVFile(reader, IPLRunsCSV.class);
            return iplCricketorsRunList.size();
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.INCORRECT_FILE_DATA);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<IPLRunsCSV> getSortedArrayByDESCOrder(String fieldName) {
        iplCricketorsRunList = iplCricketorsRunList.stream()
                .sorted(sortField.get(fieldName))
                .collect(Collectors.toList());
        Collections.reverse(iplCricketorsRunList);
        return this.iplCricketorsRunList;
    }

    public List<IPLRunsCSV> getTopCricketorsAverageScore() {
        return this.getSortedArrayByDESCOrder("average");
    }

    public List<IPLRunsCSV> getTopCricketorsStrikingRates() {
        return this.getSortedArrayByDESCOrder("strikeRate");

    }

    public List<IPLRunsCSV> getCricketorsWhoHitMaxSixFours() {
        return this.getSortedArrayByDESCOrder("max4s6s");
    }

    public List<IPLRunsCSV> getPlayerWithMaxStrikeRateSixAndFour() {
        iplCricketorsRunList = this.getSortedArrayByDESCOrder("strikeRate");
        Collections.reverse(iplCricketorsRunList);
        return this.getSortedArrayByDESCOrder("max4s6s");
    }
}
