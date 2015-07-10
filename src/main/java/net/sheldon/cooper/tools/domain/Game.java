package net.sheldon.cooper.tools.domain;

import net.sheldon.cooper.tools.player.PlayerStrategy;

public final class Game {

    private final UserChoice choice1;
    private final UserChoice choice2;
    private PlayerStrategy winner = null;

    public Game(final UserChoice choice1, final UserChoice choice2) {
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public UserChoice getChoice1() {
        return choice1;
    }

    public UserChoice getChoice2() {
        return choice2;
    }

    public PlayerStrategy getWinner() {
        return winner;
    }

    public void setWinner(final PlayerStrategy winner) {
        this.winner = winner;
    }
}
