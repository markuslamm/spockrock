package net.sheldon.cooper.tools.domain;

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
       return "Report";
    }

    private String generateResultRecord(final Game game) {
        return "Record";
    }

    private String getHeader() {
        return "#### Game results ###";
    }
}