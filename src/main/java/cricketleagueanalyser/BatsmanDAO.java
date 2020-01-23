package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class BatsmanDAO {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int mat;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "NO", required = true)
    public int notOut;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public String highScore;

    @CsvBindByName(column = "Avg", required = true)
    public Double batingAverage;

    @CsvBindByName(column = "BF", required = true)
    public int ballsFaced;

    @CsvBindByName(column = "SR", required = true)
    public Double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    public BatsmanDAO() {
    }

    public BatsmanDAO(int pos, String player, int mat, int inns, int notOut, int runs, String highScore, Double batingAverage, int ballsFaced, Double strikeRate, int century, int halfCentury, int fours, int sixes) {
        this.pos = pos;
        this.player =player;
        this.mat = mat;
        this.inns = inns;
        this.notOut = notOut;
        this.runs = runs;
        this.highScore = highScore;
        this.batingAverage = batingAverage;
        this.ballsFaced = ballsFaced;
        this.strikeRate = strikeRate;
        this.century = century;
        this.halfCentury = halfCentury;
        this.fours = fours;
        this.sixes = sixes;
    }

    @Override
    public String toString() {
        return "BatsmanDAO{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", mat=" + mat +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", batingAverage=" + batingAverage +
                ", ballsFaced=" + ballsFaced +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }
}
