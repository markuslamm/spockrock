package net.sheldon.cooper.tools;

import net.sheldon.cooper.tools.player.LizardPlayer;
import net.sheldon.cooper.tools.player.PlayerStrategy;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class PlayerTest {

    protected static final String PLAYER_NAME = "test-lizard-user";

    @Test
    public void testGetName() {
        final PlayerStrategy lizardPlayer = new LizardPlayer(PLAYER_NAME);
        assertThat(lizardPlayer.getPlayerName()).isEqualTo(PLAYER_NAME);
    }
}
