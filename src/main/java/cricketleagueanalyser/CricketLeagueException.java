package cricketleagueanalyser;

public class CricketLeagueException extends Exception {

    ExceptionType type;

    enum ExceptionType {
        IPL_FILE_PROBLEM, INCORRECT_FILE_DATA, NO_IPL_DATA
    }

    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
