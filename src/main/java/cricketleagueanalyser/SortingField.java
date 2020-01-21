package cricketleagueanalyser;

import java.util.Comparator;
import java.util.HashMap;

public class SortingField {

    private HashMap<Field, Comparator<CricketDAO>> sortField = null;

    public enum Field {
        AVEREGE, STRIKE_RATE, MAX_6S_4S, MAX_STIKE_6S_4S, GREAT_AVEREGE_STRIKE_RATE, MAX_RUN_AVERAGE, MAX_RUN, ECONOMY_RATE;
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
    }
    public Comparator<CricketDAO> getSortingField(Field field) {
        return sortField.get(field);
    }
}

