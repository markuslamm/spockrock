package net.sheldon.cooper.tools.domain;

import java.util.Arrays;

public enum Item {

    ROCK, SCISSORS, PAPER, SPOCK, LIZARD;

    static {
        ROCK.hits     = new Item[] { SCISSORS, LIZARD };
        SCISSORS.hits = new Item[] { PAPER, LIZARD };
        PAPER.hits    = new Item[] { ROCK, SPOCK };
        SPOCK.hits    = new Item[] { SCISSORS, ROCK };
        LIZARD.hits   = new Item[] { SPOCK, PAPER };
    }
    private Item[] hits;

    public boolean beats(final Item other) {
        return Arrays.asList(hits).contains(other);
    }
}
