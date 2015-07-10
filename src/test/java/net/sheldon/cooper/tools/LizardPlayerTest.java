package net.sheldon.cooper.tools;

import net.sheldon.cooper.tools.player.LizardPlayer;
import net.sheldon.cooper.tools.player.PlayerStrategy;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class LizardPlayerTest extends PlayerTest {

    @Test
    public void testChooseItem() {
        final PlayerStrategy lizardPlayer = new LizardPlayer(PLAYER_NAME);
        final Item selection = lizardPlayer.chooseItem();
        assertThat(selection).isNotNull();
        assertThat(selection).isEqualTo(Item.LIZARD);
    }

    @Test
    public void testChooseItems() {
        final PlayerStrategy lizardPlayer = new LizardPlayer(PLAYER_NAME);
        final List<Item> selections = lizardPlayer.chooseItems(5);
        assertThat(selections.size()).isEqualTo(5);
        for(final Item item : selections) {
            assertThat(item).isEqualTo(Item.LIZARD);
        }
    }
}
