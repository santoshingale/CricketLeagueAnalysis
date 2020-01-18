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
import java.util.List;
import java.util.stream.Collectors;


public class CricketLeagueAnalyser {

    List<IPLRunsCSV> iplCricketorsRunList = null;

    public CricketLeagueAnalyser() {

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

    public List<IPLRunsCSV> getTopCricketorsAverageScore() {
        List<IPLRunsCSV> sortedRunList = iplCricketorsRunList.stream()
                .sorted(Comparator.comparing(result -> result.avg))
                .collect(Collectors.toList());
        Collections.reverse(sortedRunList);
        return sortedRunList;
    }

    public List<IPLRunsCSV> getTopCricketorsStrikingRates() {
        List<IPLRunsCSV> sortedStrikingRatesList = iplCricketorsRunList.stream()
                .sorted(Comparator.comparing(result -> result.strikeRate))
                .collect(Collectors.toList());
        Collections.reverse(sortedStrikingRatesList);
        return sortedStrikingRatesList;

    }

    public List<IPLRunsCSV> getCricketorsWhoHitMaxSixFours() {
        List<IPLRunsCSV> sortedSixAndFourList = iplCricketorsRunList.stream()
                .sorted(Comparator.comparing(result -> (result.sixes * 6 + result.fours * 4 )))
                .collect(Collectors.toList());
        Collections.reverse(sortedSixAndFourList);
        return sortedSixAndFourList;
    }

    public List<IPLRunsCSV> getPlayerWithMaxStrikeRateSixAndFour() {
        List<IPLRunsCSV> sortedSixAndFourList = iplCricketorsRunList.stream()
                .sorted(Comparator.comparing(result -> result.strikeRate))
                .sorted(Comparator.comparing(result -> ((result.sixes * 6 + result.fours * 4 ))))
                .collect(Collectors.toList());
        Collections.reverse(sortedSixAndFourList);
        sortedSixAndFourList.forEach(System.out::println);
        return sortedSixAndFourList;
    }
}
