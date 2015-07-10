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
    public void testTies() {
        //TODO
    }
}
