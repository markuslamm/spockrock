package net.sheldon.cooper.tools.player;

import net.sheldon.cooper.tools.domain.Item;

import java.security.SecureRandom;

public class RandomPlayer extends AbstractPlayer {

    private static final SecureRandom random = new SecureRandom();
    private static final Item[] values = Item.values();

    public RandomPlayer(final String playerName) {
        super(playerName);
    }

    @Override
    protected Item produceItem() {
        return values[random.nextInt(values.length)];
    }
}
