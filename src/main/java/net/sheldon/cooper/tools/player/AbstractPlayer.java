package net.sheldon.cooper.tools.player;

import net.sheldon.cooper.tools.Item;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public abstract class AbstractPlayer implements PlayerStrategy {

    private final String playerName;

    public AbstractPlayer(final String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public Item chooseItem() {
        return produceItem();
    }

    @Override
    public List<Item> chooseItems(final int numMoves) {
        final List<Item> items = newArrayList();
        for(int i = 0; i < numMoves; i++) {
            items.add(produceItem());
        }
        return items;
    }

    protected abstract Item produceItem();
}
