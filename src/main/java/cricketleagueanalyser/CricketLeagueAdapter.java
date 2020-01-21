package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class CricketLeagueAdapter {

    List<CricketDAO> iplCricketorsRunList = new ArrayList<>();

    public <E> List<CricketDAO> loadCricketData(String csvFilePath ,Class <E> className) throws CricketLeagueException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> iplCricketorsRunList1 = csvBuilder.getListCSVFile(reader, className);
            if (className.getName().equals("cricketleagueanalyser.BatsmanDAO")) {
                StreamSupport.stream(iplCricketorsRunList1.spliterator(), false)
                        .map(BatsmanDAO.class::cast)
                        .forEach(cricketData -> iplCricketorsRunList.add(new CricketDAO(cricketData)));
                return iplCricketorsRunList;
            } else if (className.getName().equals("cricketleagueanalyser.BowlerDAO")) {
                StreamSupport.stream(iplCricketorsRunList1.spliterator(), false)
                        .map(BowlerDAO.class::cast)
                        .forEach(cricketData -> iplCricketorsRunList.add(new CricketDAO(cricketData)));
                return iplCricketorsRunList;
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
