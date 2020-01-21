package cricketleagueanalyser;

import java.util.Comparator;
import java.util.HashMap;

public class SortingField {

    private HashMap<Field, Comparator<CricketDAO>> sortField = null;

    public enum Field {
        AVEREGE, STRIKE_RATE, MAX_6S_4S, MAX_STIKE_6S_4S, GREAT_AVEREGE_STRIKE_RATE, MAX_RUN_AVERAGE, MAX_RUN, ECONOMY_RATE, MAX_4W_5W, MAX_STRIKE_4W_5W, WICKET, WICKET_AVERAGE;
    }

    public SortingField() {
        this.sortField = new HashMap<>();
        this.sortField.put(Field.AVEREGE, Comparator.comparing(cricketDAO -> cricketDAO.avg));
        this.sortField.put(Field.STRIKE_RATE, Comparator.comparing(cricketDAO -> cricketDAO.strikeRate));
        this.sortField.put(Field.MAX_6S_4S, Comparator.comparing(cricketDAO -> (cricketDAO.sixes * 6 + cricketDAO.fours * 4)));
        this.sortField.put(Field.MAX_STIKE_6S_4S, sortField.get(Field.MAX_6S_4S).thenComparing(cricketDAO -> cricketDAO.strikeRate));
        this.sortField.put(Field.GREAT_AVEREGE_STRIKE_RATE, sortField.get(Field.AVEREGE).thenComparing(cricketDAO -> cricketDAO.strikeRate));
        this.sortField.put(Field.MAX_RUN, Comparator.comparing(cricketDAO -> cricketDAO.runs));
        this.sortField.put(Field.MAX_RUN_AVERAGE, sortField.get(Field.MAX_RUN).thenComparing(cricketDAO -> cricketDAO.avg));
        this.sortField.put(Field.ECONOMY_RATE, Comparator.comparing(cricketDAO -> cricketDAO.economyRate));
        this.sortField.put(Field.MAX_4W_5W, Comparator.comparing(cricketDAO -> (cricketDAO.fourWicket * 4 + cricketDAO.fiveWicket * 5)));
        this.sortField.put(Field.MAX_STRIKE_4W_5W, sortField.get(Field.MAX_4W_5W).thenComparing(cricketDAO -> cricketDAO.strikeRate));
        this.sortField.put(Field.WICKET, Comparator.comparing(cricketDAO -> cricketDAO.wicket));
        this.sortField.put(Field.WICKET_AVERAGE, sortField.get(Field.WICKET).thenComparing(cricketDAO -> cricketDAO.avg));

    }

    public Comparator<CricketDAO> getSortingField(Field field) {
        return sortField.get(field);
    }
}

