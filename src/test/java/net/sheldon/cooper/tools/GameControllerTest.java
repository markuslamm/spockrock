package net.sheldon.cooper.tools;

import net.sheldon.cooper.tools.domain.Game;
import net.sheldon.cooper.tools.domain.Game.GameResult;
import net.sheldon.cooper.tools.domain.Item;
import net.sheldon.cooper.tools.domain.UserChoice;
import net.sheldon.cooper.tools.player.PlayerStrategy;
import net.sheldon.cooper.tools.player.RandomPlayer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class GameControllerTest {

    private PlayerStrategy player1;
    private PlayerStrategy player2;

    @Before
    public void setUp() {
        player1 = new RandomPlayer("player1");
        player2 = new RandomPlayer("player2");
    }

    @Test
    public void testStartGame() {
        final GameController controller = new GameController(player1, player2);
        final List<Game> games = controller.startGame(5);
        assertThat(games).isNotNull();
        assertThat(games.size()).isEqualTo(5);
    }

    @Test
    public void testTieGame() {
        final GameController controller = new GameController(player1, player2);
        UserChoice choice1, choice2;
        final Item[] items = Item.values();
        for (final Item item : items) {
            choice1 = new UserChoice(player1, item);
            choice2 = new UserChoice(player2, item);
            Game game = new Game(choice1, choice2);
            assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.TIE);
        }
    }

    @Test
    public void testWinGame() {
        final GameController controller = new GameController(player1, player2);
        //Rock crushes scissors
        UserChoice choice1 = new UserChoice(player1, Item.ROCK);
        UserChoice choice2 = new UserChoice(player2, Item.SCISSORS);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Scissors cuts paper
        choice1 = new UserChoice(player1, Item.SCISSORS);
        choice2 = new UserChoice(player2, Item.PAPER);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Paper covers rock
        choice1 = new UserChoice(player1, Item.PAPER);
        choice2 = new UserChoice(player2, Item.ROCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Rock crushes lizard
        choice1 = new UserChoice(player1, Item.ROCK);
        choice2 = new UserChoice(player2, Item.LIZARD);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Lizard poisons Spock
        choice1 = new UserChoice(player1, Item.LIZARD);
        choice2 = new UserChoice(player2, Item.SPOCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Spock smashes scissors
        choice1 = new UserChoice(player1, Item.SPOCK);
        choice2 = new UserChoice(player2, Item.SCISSORS);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Scissors decapitates lizard
        choice1 = new UserChoice(player1, Item.SCISSORS);
        choice2 = new UserChoice(player2, Item.LIZARD);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Lizard eats paper
        choice1 = new UserChoice(player1, Item.LIZARD);
        choice2 = new UserChoice(player2, Item.PAPER);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Paper disproves Spock
        choice1 = new UserChoice(player1, Item.PAPER);
        choice2 = new UserChoice(player2, Item.SPOCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);

        //Spock vaporizes rock
        choice1 = new UserChoice(player1, Item.SPOCK);
        choice2 = new UserChoice(player2, Item.ROCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.WIN);
    }

    @Test
    public void testLoseGame() {
        final GameController controller = new GameController(player1, player2);
        //Rock crushes scissors
        UserChoice choice1 = new UserChoice(player1, Item.SCISSORS);
        UserChoice choice2 = new UserChoice(player2, Item.ROCK);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Scissors cuts paper
        choice1 = new UserChoice(player1, Item.PAPER);
        choice2 = new UserChoice(player2, Item.SCISSORS);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Paper covers rock
        choice1 = new UserChoice(player1, Item.ROCK);
        choice2 = new UserChoice(player2, Item.PAPER);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Rock crushes lizard
        choice1 = new UserChoice(player1, Item.LIZARD);
        choice2 = new UserChoice(player2, Item.ROCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Lizard poisons Spock
        choice1 = new UserChoice(player1, Item.SPOCK);
        choice2 = new UserChoice(player2, Item.LIZARD);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Spock smashes scissors
        choice1 = new UserChoice(player1, Item.SCISSORS);
        choice2 = new UserChoice(player2, Item.SPOCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Scissors decapitates lizard
        choice1 = new UserChoice(player1, Item.LIZARD);
        choice2 = new UserChoice(player2, Item.SCISSORS);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Lizard eats paper
        choice1 = new UserChoice(player1, Item.PAPER);
        choice2 = new UserChoice(player2, Item.LIZARD);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Paper disproves Spock
        choice1 = new UserChoice(player1, Item.SPOCK);
        choice2 = new UserChoice(player2, Item.PAPER);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);

        //Spock vaporizes rock
        choice1 = new UserChoice(player1, Item.ROCK);
        choice2 = new UserChoice(player2, Item.SPOCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(GameResult.LOSE);
    }
}
