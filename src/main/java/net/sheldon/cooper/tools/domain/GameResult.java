package net.sheldon.cooper.tools.domain;

import net.sheldon.cooper.tools.player.PlayerStrategy;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

class GameResult {

    private int iterations = 0;
    private PlayerStrategy player1;
    private PlayerStrategy player2;

    private Map<PlayerStrategy, Integer> resultMap;

    public GameResult(final List<Game> games) {
        if (games.size() > 0) {
            player1 = games.get(0).getChoice1().getPlayer();
            player2 = games.get(0).getChoice2().getPlayer();
            resultMap = newHashMap();
            resultMap.put(player1, iterations);
            resultMap.put(player2, iterations);
            resultMap.put(null, iterations);
            for (final Game game : games) {
                int wins = resultMap.get(game.getWinner());
                resultMap.put(game.getWinner(), ++wins);
                iterations++;
            }
        }
    }

    public int getPlayer1Wins() {
        return resultMap.get(player1);
    }

    public int getPlayer2Wins() {
        return resultMap.get(player2);
    }

    public int getTies() {
        return resultMap.get(null);
    }

    public int getIterations() {
        return iterations;
    }
}
