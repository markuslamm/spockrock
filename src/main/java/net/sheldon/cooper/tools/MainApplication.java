package net.sheldon.cooper.tools;

import net.sheldon.cooper.tools.controller.GameController;
import net.sheldon.cooper.tools.domain.Game;
import net.sheldon.cooper.tools.domain.GameReport;
import net.sheldon.cooper.tools.player.LizardPlayer;
import net.sheldon.cooper.tools.player.PlayerStrategy;
import net.sheldon.cooper.tools.player.RandomPlayer;

import java.util.List;

class MainApplication {

    private static final int ITERATIONS = 5;
    private static final String PLAYER1 = "random-player";
    private static final String PLAYER2 = "lizard-player";

    public static void main(final String[] args) {
        final PlayerStrategy randomPlayer = new RandomPlayer(PLAYER1);
        final PlayerStrategy lizardPlayer = new LizardPlayer(PLAYER2);

        final GameController controller = new GameController(randomPlayer, lizardPlayer);
        final List<Game> playedGames = controller.startGame(ITERATIONS);
        final GameReport report = controller.createReport(playedGames);

        System.out.println(report.getFullResult());
    }
}
