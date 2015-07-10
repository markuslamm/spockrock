package net.sheldon.cooper.tools;

import net.sheldon.cooper.tools.domain.Game;
import net.sheldon.cooper.tools.domain.Game.GameResult;
import net.sheldon.cooper.tools.domain.GameReport;
import net.sheldon.cooper.tools.domain.UserChoice;
import net.sheldon.cooper.tools.player.PlayerStrategy;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class GameController {

    private PlayerStrategy player1;
    private PlayerStrategy player2;

    public GameController(final PlayerStrategy player1, final PlayerStrategy player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public List<Game> startGame(final int iterations) {
        if (iterations < 1) {
            return newArrayList();
        }
        return play(iterations);
    }

    public GameReport createReport(final List<Game> games) {
        return new GameReport(games);
    }

    private List<Game> play(final int iterations) {
        final Iterator<UserChoice> randomChoices = createPlayerChoices(iterations, player1).iterator();
        final Iterator<UserChoice> lizardChoices = createPlayerChoices(iterations, player2).iterator();
        final List<Game> games = newArrayList();
        for(int i = 0; i < iterations; i++) {
            final Game game = new Game(randomChoices.next(), lizardChoices.next());
            game.setResult(evaluateGame(game));
            games.add(game);
        }
        return games;
    }

    GameResult evaluateGame(final Game game) {
        return game.getChoice1().getSelectedItem() == game.getChoice2().getSelectedItem() ? GameResult.TIE :
                game.getChoice1().getSelectedItem().beats(game.getChoice2().getSelectedItem()) ? GameResult.WIN :
                        GameResult.LOSE ;
    }


    private List<UserChoice> createPlayerChoices(final int iterations, final PlayerStrategy playerStrategy) {
        final List<UserChoice> randomMoves = newArrayList();
        randomMoves.addAll(playerStrategy.chooseItems(iterations).stream()
                .map(item -> new UserChoice(playerStrategy, item)).collect(Collectors.toList()));
        return randomMoves;
    }
}
