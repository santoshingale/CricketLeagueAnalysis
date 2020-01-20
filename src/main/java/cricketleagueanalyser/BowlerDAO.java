package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class BowlerDAO {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int mat;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "Ov", required = true)
    public int over;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wicket;

    @CsvBindByName(column = "BBI", required = true)
    public int bestBowlingIn;

    @CsvBindByName(column = "Avg", required = true)
    public String avg;

    @CsvBindByName(column = "Econ", required = true)
    public Double economyRate;

    @CsvBindByName(column = "SR", required = true)
    public String strikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fours;

    @CsvBindByName(column = "5w", required = true)
    public int sixes;
}
