package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class CricketLeagueAnalyser {
    public void loadCricketCSVFile(String csvFilePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<IPLRunsCSV> listCSVFile = csvBuilder.getListCSVFile(reader, IPLRunsCSV.class);
            System.out.println(listCSVFile.toString());
        } catch (IOException | CSVBuilderException e) {
            e.printStackTrace();
        }
    }
}
