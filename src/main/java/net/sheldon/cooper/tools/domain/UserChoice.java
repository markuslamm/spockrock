package net.sheldon.cooper.tools.domain;

import net.sheldon.cooper.tools.player.PlayerStrategy;

public final class UserChoice {

    private final PlayerStrategy player;
    private final Item selectedItem;

    public UserChoice(final PlayerStrategy player, final Item selectedItem) {
        this.player = player;
        this.selectedItem = selectedItem;
    }

    public PlayerStrategy getPlayer() {
        return player;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    @Override
    public String toString() {
        return getPlayer().getPlayerName() + ":" + getSelectedItem().name();
    }
}
