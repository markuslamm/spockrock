package net.sheldon.cooper.tools.domain;

import java.util.List;

import static java.lang.String.format;

public class GameReport {

    private final String NEWLINE = System.getProperty("line.separator");
    private final List<Game> games;
    private final String TEMPLATE = "################################";

    public GameReport(final List<Game> games) {
        this.games = games;
    }

    public String getFullResult() {
        final StringBuilder sb = new StringBuilder(getHeader()).append(NEWLINE);
        if (games.size() > 0) {
            for (final Game game : games) {
                sb.append(generateResultRecord(game)).append(NEWLINE);
            }
            return sb.append(NEWLINE).append(generateSummary(games)).toString();
        }
        return sb.append("No games played").toString();
    }

    private String generateSummary(final List<Game> games) {
        final StringBuilder sb = new StringBuilder(TEMPLATE).append(" Summary ").append(TEMPLATE).append(NEWLINE);
        final GameResult result = new GameResult(games);
        final String formatPlayer1 = format("Player %s wins %d of %d games", games.get(0).getChoice1().getPlayer()
                .getPlayerName(), result.getPlayer1Wins(), result.getIterations());
        final String formatPlayer2 = format("Player %s wins %d of %d games", games.get(0).getChoice2().getPlayer()
                .getPlayerName(), result.getPlayer2Wins(), result.getIterations());
        final String formatTies = format("Ties: %d of %d games", result.getTies(), result.getIterations());
        sb.append(formatPlayer1).append(NEWLINE);
        sb.append(formatPlayer2).append(NEWLINE);
        sb.append(formatTies).append(NEWLINE);
        return sb.toString();
    }

    private String generateResultRecord(final Game game) {
        final String result = (game.getWinner() == null) ? "TIE" : format("%s wins", game.getWinner().getPlayerName());
        return format("-> %s against %s results in: %s", game.getChoice1(), game.getChoice2(), result);
    }

    private String getHeader() {
        return format("%s Game results (%d rounds) %s", TEMPLATE, games.size(), TEMPLATE);
    }
}