package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class CricketLeagueAdapter {

    Map<String, CricketDAO> iplCricketorsMap = new HashMap<>();

    public abstract Map<String, CricketDAO> loadCricketData(Class<BatsmanDAO> batsmanDAOClass, String... csvFilePath) throws ClassCastException, CricketLeagueException;

    public <E> Map<String,CricketDAO> loadCricketData(Class<E> className, String csvFilePath) throws CricketLeagueException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> iplCricketorsRunList1 = csvBuilder.getListCSVFile(reader, className);
            if (className.getName().equals("cricketleagueanalyser.BatsmanDAO")) {
                StreamSupport.stream(iplCricketorsRunList1.spliterator(), false)
                        .map(BatsmanDAO.class::cast)
                        .forEach(cricketData -> iplCricketorsMap.put(cricketData.player,new CricketDAO(cricketData)));
                return iplCricketorsMap;
            } else if (className.getName().equals("cricketleagueanalyser.BowlerDAO")) {
                StreamSupport.stream(iplCricketorsRunList1.spliterator(), false)
                        .map(BowlerDAO.class::cast)
                        .forEach(cricketData -> iplCricketorsMap.put(cricketData.player,new CricketDAO(cricketData)));
                return iplCricketorsMap;
            }
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.INCORRECT_FILE_DATA);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return null;
    }
}
