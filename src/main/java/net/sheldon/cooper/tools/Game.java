package net.sheldon.cooper.tools;

public final class Game {

    private final UserChoice choice1;
    private final UserChoice choice2;
    private GameResult result;

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

    public GameResult getResult() {
        return result;
    }

    public void setResult(final GameResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Game {" +
                "choice1=" + choice1 +
                ", choice2=" + choice2 +
                '}';
    }
}
