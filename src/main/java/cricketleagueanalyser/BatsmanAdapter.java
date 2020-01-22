package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class BatsmanAdapter extends CricketLeagueAdapter {
    Map<String, CricketDAO> cricketDAOMap = null;

    @Override
    public Map<String, CricketDAO> loadCricketData(Class<BatsmanDAO> batsmanDAOClass, String... csvFilePath) throws ClassCastException, CricketLeagueException {
        cricketDAOMap = super.loadCricketData(BatsmanDAO.class, csvFilePath[0]);
        if (csvFilePath.length == 2) {
            return loadBowlerData(BowlerDAO.class, csvFilePath[1]);
        }
        return cricketDAOMap;
    }

    public <E> Map<String, CricketDAO> loadBowlerData(Class<E> className, String csvFilePath) throws CricketLeagueException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> iplCricketorsRunList1 = csvBuilder.getListCSVFile(reader, className);
            StreamSupport.stream(iplCricketorsRunList1.spliterator(), false)
                    .map(CricketDAO.class::cast)
                    .filter(cricketData -> cricketDAOMap.get(cricketData) != null)
                    .forEach(cricketData -> cricketData = new CricketDAO(iplCricketorsMap.get(cricketData), cricketData));

            return iplCricketorsMap;
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
