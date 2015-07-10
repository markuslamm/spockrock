package net.sheldon.cooper.tools.domain;

import net.sheldon.cooper.tools.player.PlayerStrategy;
import net.sheldon.cooper.tools.player.RandomPlayer;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void testCreateResult() {
        final PlayerStrategy player1 = new RandomPlayer("player1");
        final PlayerStrategy player2 = new RandomPlayer("player2");

        //player1 wins
        UserChoice choice1 = new UserChoice(player1, Item.ROCK);
        UserChoice choice2 = new UserChoice(player2, Item.SCISSORS);
        final Game game1 = new Game(choice1, choice2);
        game1.setWinner(player1);

        //player2 wins
        choice1 = new UserChoice(player1, Item.SCISSORS);
        choice2 = new UserChoice(player2, Item.ROCK);
        final Game game2 = new Game(choice1, choice2);
        game2.setWinner(player2);

        //tie
        choice1 = new UserChoice(player1, Item.SCISSORS);
        choice2 = new UserChoice(player2, Item.SCISSORS);
        final Game game3 = new Game(choice1, choice2);
        game3.setWinner(null);

        final GameResult result = new GameResult(newArrayList(game1, game2, game3));
        assertThat(result.getPlayer1Wins()).isEqualTo(1);
        assertThat(result.getPlayer2Wins()).isEqualTo(1);
        assertThat(result.getTies()).isEqualTo(1);
        assertThat(result.getIterations()).isEqualTo(3);
    }
}
