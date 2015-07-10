package net.sheldon.cooper.tools.controller;

import net.sheldon.cooper.tools.domain.Game;
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
    private GameController controller;

    @Before
    public void setUp() {
        player1 = new RandomPlayer("player1");
        player2 = new RandomPlayer("player2");
        controller = new GameController(player1, player2);
    }

    @Test
    public void testStartGame() {
        final List<Game> games = controller.startGame(5);
        assertThat(games).isNotNull();
        assertThat(games.size()).isEqualTo(5);
    }

    @Test
    public void testTieGames() {
        UserChoice choice1, choice2;
        final Item[] items = Item.values();
        for (final Item item : items) {
            choice1 = new UserChoice(player1, item);
            choice2 = new UserChoice(player2, item);
            Game game = new Game(choice1, choice2);
            assertThat(controller.evaluateGame(game)).isNull();
        }
    }

    @Test
    public void testRockCrushesScissors() {
        UserChoice choice1 = new UserChoice(player1, Item.ROCK);
        UserChoice choice2 = new UserChoice(player2, Item.SCISSORS);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.SCISSORS);
        choice2 = new UserChoice(player2, Item.ROCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testScissorsCutsPaper() {
        UserChoice choice1 = new UserChoice(player1, Item.SCISSORS);
        UserChoice choice2 = new UserChoice(player2, Item.PAPER);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.PAPER);
        choice2 = new UserChoice(player2, Item.SCISSORS);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testPaperCoversRock() {
        UserChoice choice1 = new UserChoice(player1, Item.PAPER);
        UserChoice choice2 = new UserChoice(player2, Item.ROCK);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.ROCK);
        choice2 = new UserChoice(player2, Item.PAPER);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testRockCrushesLizard() {
        UserChoice choice1 = new UserChoice(player1, Item.ROCK);
        UserChoice choice2 = new UserChoice(player2, Item.LIZARD);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.LIZARD);
        choice2 = new UserChoice(player2, Item.ROCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testLizardPoisensSpock() {
        UserChoice choice1 = new UserChoice(player1, Item.LIZARD);
        UserChoice choice2 = new UserChoice(player2, Item.SPOCK);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.SPOCK);
        choice2 = new UserChoice(player2, Item.LIZARD);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testSpockSmashesScissors() {
        UserChoice choice1 = new UserChoice(player1, Item.SPOCK);
        UserChoice choice2 = new UserChoice(player2, Item.SCISSORS);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.SCISSORS);
        choice2 = new UserChoice(player2, Item.SPOCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testScissorsDecapitatesLizard() {
        UserChoice choice1 = new UserChoice(player1, Item.SCISSORS);
        UserChoice choice2 = new UserChoice(player2, Item.LIZARD);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.LIZARD);
        choice2 = new UserChoice(player2, Item.SCISSORS);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testLizardEatsPaper() {
        UserChoice choice1 = new UserChoice(player1, Item.LIZARD);
        UserChoice choice2 = new UserChoice(player2, Item.PAPER);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.PAPER);
        choice2 = new UserChoice(player2, Item.LIZARD);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testPaperDisprovesSpock() {
        UserChoice choice1 = new UserChoice(player1, Item.PAPER);
        UserChoice choice2 = new UserChoice(player2, Item.SPOCK);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.SPOCK);
        choice2 = new UserChoice(player2, Item.PAPER);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }

    @Test
    public void testSpockVaporizesRock() {
        UserChoice choice1 = new UserChoice(player1, Item.SPOCK);
        UserChoice choice2 = new UserChoice(player2, Item.ROCK);
        Game game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player1);

        choice1 = new UserChoice(player1, Item.ROCK);
        choice2 = new UserChoice(player2, Item.SPOCK);
        game = new Game(choice1, choice2);
        assertThat(controller.evaluateGame(game)).isEqualTo(player2);
    }
}
