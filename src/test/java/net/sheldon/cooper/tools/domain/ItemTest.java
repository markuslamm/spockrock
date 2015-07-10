package net.sheldon.cooper.tools.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void testBeats() {
        assertThat(Item.ROCK.beats(Item.LIZARD)).isTrue();
        assertThat(Item.SCISSORS.beats(Item.PAPER)).isTrue();
        assertThat(Item.PAPER.beats(Item.ROCK)).isTrue();
        assertThat(Item.ROCK.beats(Item.LIZARD)).isTrue();
        assertThat(Item.LIZARD.beats(Item.SPOCK)).isTrue();
        assertThat(Item.SPOCK.beats(Item.SCISSORS)).isTrue();
        assertThat(Item.SCISSORS.beats(Item.LIZARD)).isTrue();
        assertThat(Item.LIZARD.beats(Item.PAPER)).isTrue();
        assertThat(Item.PAPER.beats(Item.SPOCK)).isTrue();
        assertThat(Item.SPOCK.beats(Item.ROCK)).isTrue();
    }

    @Test
    public void testLose() {
        assertThat(Item.LIZARD.beats(Item.ROCK)).isFalse();
        assertThat(Item.PAPER.beats(Item.SCISSORS)).isFalse();
        assertThat(Item.ROCK.beats(Item.PAPER)).isFalse();
        assertThat(Item.LIZARD.beats(Item.ROCK)).isFalse();
        assertThat(Item.SPOCK.beats(Item.LIZARD)).isFalse();
        assertThat(Item.SCISSORS.beats(Item.SPOCK)).isFalse();
        assertThat(Item.LIZARD.beats(Item.SCISSORS)).isFalse();
        assertThat(Item.PAPER.beats(Item.LIZARD)).isFalse();
        assertThat(Item.SPOCK.beats(Item.PAPER)).isFalse();
        assertThat(Item.ROCK.beats(Item.SPOCK)).isFalse();
    }

    @Test
    public void testTie() {
        assertThat(Item.LIZARD.beats(Item.LIZARD)).isFalse();
        assertThat(Item.PAPER.beats(Item.PAPER)).isFalse();
        assertThat(Item.ROCK.beats(Item.ROCK)).isFalse();
        assertThat(Item.SCISSORS.beats(Item.SCISSORS)).isFalse();
        assertThat(Item.SPOCK.beats(Item.SPOCK)).isFalse();
    }
}
