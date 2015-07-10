package net.sheldon.cooper.tools;

import net.sheldon.cooper.tools.domain.Game;
import net.sheldon.cooper.tools.domain.GameReport;
import net.sheldon.cooper.tools.player.LizardPlayer;
import net.sheldon.cooper.tools.player.PlayerStrategy;
import net.sheldon.cooper.tools.player.RandomPlayer;

import java.util.List;

import static java.lang.String.format;

public class MainApplication {

    private static final int ITERATIONS = 5;
    private static final String PLAYER1 = "random-player";
    private static final String PLAYER2 = "lizard-player";

    public static void main(final String[] args) {
        System.out.println("Starting main application...");

        final PlayerStrategy randomPlayer = new RandomPlayer(PLAYER1);
        System.out.println(format("Created Player '%s'", PLAYER1));

        final PlayerStrategy lizardPlayer = new LizardPlayer(PLAYER2);
        System.out.println(format("Created Player '%s'", PLAYER2));

        final GameController controller = new GameController(randomPlayer, lizardPlayer);
        final List<Game> playedGames = controller.startGame(ITERATIONS);
        final GameReport report = controller.createReport(playedGames);
        System.out.println(report.getFullResult());
    }
}
