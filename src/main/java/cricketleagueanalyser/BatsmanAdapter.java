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

public class BatsmanAdapter extends CricketLeagueAdapter {
    Map<String, CricketDAO> cricketDAOMap = new HashMap<>();

    @Override
    public Map<String, CricketDAO> loadCricketData(String... csvFilePath) throws ClassCastException, CricketLeagueException {
        cricketDAOMap = super.loadCricketData(BatsmanDAO.class, csvFilePath[0]);
        if (csvFilePath.length == 2) {
            return loadBowlerData(csvFilePath[1]);
        }
        return cricketDAOMap;
    }

    public <E> Map<String, CricketDAO> loadBowlerData(String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<BowlerDAO> iplCricketorsbowlerList = csvBuilder.getListCSVFile(reader, BowlerDAO.class);
            StreamSupport.stream(iplCricketorsbowlerList.spliterator(), false)
                    .filter(cricketData -> cricketDAOMap.get(cricketData.player) != null )
                    .forEach(cricketData ->  {cricketDAOMap.get(cricketData.player)
                            .bowlingAverage = cricketData.bowlingAverage;
                            cricketDAOMap.get(cricketData.player).wicket = cricketData.wicket;});
            return cricketDAOMap;
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
