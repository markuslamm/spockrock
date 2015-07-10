package net.sheldon.cooper.tools;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class GameReport {

    public static final GameReport EMPTY = new GameReport(newArrayList()) ;

    private final String NEWLINE = System.getProperty("line.separator");

    private final List<Game> games;

    public GameReport(final List<Game> games) {
        this.games = games;
    }

    public String getFullResult() {
        final StringBuilder result = new StringBuilder(getHeader()).append(NEWLINE);
        for(final Game game : games) {
            result.append(generateResultRecord(game)).append(NEWLINE);
        }
        return result.toString();
    }

    private String generateResultRecord(final Game game) {
        return "Record";
    }

    private String getHeader() {
        return "#### Game results ###";
    }
}