package net.sheldon.cooper.tools.domain;

import net.sheldon.cooper.tools.player.PlayerStrategy;

public final class Game {

    private final UserChoice choice1;
    private final UserChoice choice2;
    private GameResult result;
    private PlayerStrategy winner = null;

    public enum GameResult { UNDEFINED, WIN, LOSE, TIE }

    public Game(final UserChoice choice1, final UserChoice choice2) {
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.result = GameResult.UNDEFINED;
    }

    public UserChoice getChoice1() {
        return choice1;
    }

    public UserChoice getChoice2() {
        return choice2;
    }

    public void setResult(final GameResult result) {
        this.result = result;
    }

    public PlayerStrategy getWinner() {
        return winner;
    }

    public void setWinner(final PlayerStrategy winner) {
        this.winner = winner;
    }
}
