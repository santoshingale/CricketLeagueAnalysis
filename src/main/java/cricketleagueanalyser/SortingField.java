package cricketleagueanalyser;

import java.util.Comparator;
import java.util.HashMap;

public class SortingField {

    private HashMap<Field, Comparator<BatsmanDAO>> sortField = null;

    public enum Field {
        AVEREGE, STRIKE_RATE, MAX_6S_4S, MAX_STIKE_6S_4S, GREAT_AVEREGE_STRIKE_RATE, MAX_RUN_AVERAGE, MAX_RUN;
    }

    public SortingField() {
        this.sortField = new HashMap<>();
        this.sortField.put(Field.AVEREGE, Comparator.comparing(batsmanDAO -> batsmanDAO.avg));
        this.sortField.put(Field.STRIKE_RATE, Comparator.comparing(batsmanDAO -> batsmanDAO.strikeRate));
        this.sortField.put(Field.MAX_6S_4S, Comparator.comparing(batsmanDAO -> (batsmanDAO.sixes * 6 + batsmanDAO.fours * 4)));
        this.sortField.put(Field.MAX_STIKE_6S_4S, sortField.get(Field.MAX_6S_4S).thenComparing(batsmanDAO -> batsmanDAO.strikeRate));
        this.sortField.put(Field.GREAT_AVEREGE_STRIKE_RATE, sortField.get(Field.AVEREGE).thenComparing(batsmanDAO -> batsmanDAO.strikeRate));
        this.sortField.put(Field.MAX_RUN, Comparator.comparing(batsmanDAO -> batsmanDAO.runs));
        this.sortField.put(Field.MAX_RUN_AVERAGE, sortField.get(Field.MAX_RUN).thenComparing(batsmanDAO -> batsmanDAO.avg));
    }
    public Comparator<BatsmanDAO> getSortingField(Field field) {
        return sortField.get(field);
    }
}

