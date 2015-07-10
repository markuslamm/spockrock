package net.sheldon.cooper.tools.player;

import net.sheldon.cooper.tools.domain.Item;

public class LizardPlayer extends AbstractPlayer {

    public LizardPlayer(final String playerName) {
        super(playerName);
    }

    @Override
    protected Item produceItem() {
        return Item.LIZARD;
    }
}
