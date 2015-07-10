package net.sheldon.cooper.tools.player;

import net.sheldon.cooper.tools.domain.Item;

import java.util.List;

public interface PlayerStrategy {

    String getPlayerName();

    Item chooseItem();

    List<Item> chooseItems(int numMoves);
}
