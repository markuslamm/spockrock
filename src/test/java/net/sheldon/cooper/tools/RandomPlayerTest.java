package net.sheldon.cooper.tools;

import net.sheldon.cooper.tools.player.PlayerStrategy;
import net.sheldon.cooper.tools.player.RandomPlayer;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class RandomPlayerTest extends PlayerTest {

    @Test
    public void testChooseItem() {
        final PlayerStrategy randomPlayer = new RandomPlayer(PLAYER_NAME);
        final Item selection = randomPlayer.chooseItem();
        assertThat(selection).isNotNull();
    }

    @Test
    public void testChooseItems() {
        final PlayerStrategy randomPlayer = new RandomPlayer(PLAYER_NAME);
        final List<Item> selections = randomPlayer.chooseItems(5);
        assertThat(selections.size()).isEqualTo(5);
    }
}
