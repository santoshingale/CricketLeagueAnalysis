package cricketleagueanalyser;

public class CricketDAO {
    public int pos;
    public String player;
    public int mat;
    public int inns;
    public int notOut;
    public int runs;
    public String highScore;
    public double batingAverage;
    public double bowlingAverage;
    public int ballsFaced;
    public double strikeRate;
    public int century;
    public int halfCentury;
    public int fours;
    public int sixes;
    public double over;
    public int wicket;
    public int bestBowlingIn;
    public double economyRate;
    public int fourWicket;
    public int fiveWicket;

    public CricketDAO(BatsmanDAO batsmanDAO) {
        this.pos = batsmanDAO.pos;
        this.player = batsmanDAO.player;
        this.mat = batsmanDAO.mat;
        this.inns = batsmanDAO.inns;
        this.notOut = batsmanDAO.notOut;
        this.runs = batsmanDAO.runs;
        this.highScore = batsmanDAO.highScore;
        this.batingAverage = batsmanDAO.batingAverage;
        this.ballsFaced = batsmanDAO.ballsFaced;
        this.strikeRate = batsmanDAO.strikeRate;
        this.century = batsmanDAO.century;
        this.halfCentury = batsmanDAO.halfCentury;
        this.fours = batsmanDAO.fours;
        this.sixes = batsmanDAO.sixes;
    }

    public CricketDAO(BowlerDAO bowlerDAO) {
        this.pos = bowlerDAO.pos;
        this.player = bowlerDAO.player;
        this.mat = bowlerDAO.mat;
        this.inns = bowlerDAO.inns;
        this.over = bowlerDAO.over;
        this.runs = bowlerDAO.runs;
        this.wicket = bowlerDAO.wicket;
        this.bestBowlingIn = bowlerDAO.bestBowlingIn;
        this.bowlingAverage = bowlerDAO.bowlingAverage;
        this.economyRate = bowlerDAO.economyRate;
        this.strikeRate = bowlerDAO.strikeRate;
        this.fourWicket = bowlerDAO.fourWicket;
        this.fiveWicket = bowlerDAO.fiveWicket;
    }

    public CricketDAO(CricketDAO cricketDAO, CricketDAO bowlerDAO) {
        cricketDAO.over=bowlerDAO.over;
        cricketDAO.wicket=bowlerDAO.wicket;
        cricketDAO.bestBowlingIn=bowlerDAO.bestBowlingIn;
        cricketDAO.economyRate=bowlerDAO.economyRate;
        cricketDAO.fourWicket=bowlerDAO.fourWicket;
        cricketDAO.fiveWicket=bowlerDAO.fiveWicket;
    }


    @Override
    public String toString() {
        return "CricketDAO{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", mat=" + mat +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", batingAverage=" + batingAverage +
                ", bowlingAverage=" + bowlingAverage +
                ", ballsFaced=" + ballsFaced +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", over=" + over +
                ", wicket=" + wicket +
                ", bestBowlingIn=" + bestBowlingIn +
                ", economyRate=" + economyRate +
                ", fourWicket=" + fourWicket +
                ", fiveWicket=" + fiveWicket +
                '}';
    }

    public Object getCensusDTO(CricketLeagueAnalyser.BatingOrBowling batingOrBowling) {
        if (batingOrBowling.equals(CricketLeagueAnalyser.BatingOrBowling.BATING))
            return new BatsmanDAO(pos, player, mat, inns, notOut, runs, highScore, batingAverage, ballsFaced, strikeRate, century, halfCentury, fours, sixes);
        return new BowlerDAO(pos, player, mat, inns, over, runs, wicket, bestBowlingIn, bowlingAverage, economyRate, strikeRate, fourWicket, fiveWicket);
    }
}
