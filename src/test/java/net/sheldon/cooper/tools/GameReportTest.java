//package net.sheldon.cooper.tools;
//
//import net.sheldon.cooper.tools.spockrock.domain.Game;
//import net.sheldon.cooper.tools.spockrock.domain.GameReport;
//import net.sheldon.cooper.tools.spockrock.domain.Item;
//import net.sheldon.cooper.tools.spockrock.domain.UserChoice;
//import net.sheldon.cooper.tools.spockrock.player.LizardPlayer;
//import net.sheldon.cooper.tools.spockrock.player.PlayerStrategy;
//import net.sheldon.cooper.tools.spockrock.player.RandomPlayer;
//import org.junit.Before;
//import org.junit.Test;
//
//import static com.google.common.collect.Lists.newArrayList;
//import static org.assertj.core.api.StrictAssertions.assertThat;
//
//public class GameReportTest {
//
//    private PlayerStrategy lizardPlayer;
//    private PlayerStrategy randomPlayer;
//
//    private Game game1;
//    private Game game2;
//    private Game game3;
//    private Game game4;
//
//    @Before
//    public void setUp() {
//        lizardPlayer = new LizardPlayer("LizardPlayer");
//        randomPlayer = new RandomPlayer("RandomPlayer");
//        game1 = new Game(new UserChoice(lizardPlayer, Item.LIZARD), new UserChoice(randomPlayer, Item.ROCK));
//        game2 = new Game(new UserChoice(lizardPlayer, lizardPlayer.chooseItem()), new UserChoice(randomPlayer, Item.PAPER));
//        game3 = new Game(new UserChoice(lizardPlayer, lizardPlayer.chooseItem()), new UserChoice(randomPlayer, Item.SCISSORS));
//        game4 = new Game(new UserChoice(lizardPlayer, lizardPlayer.chooseItem()), new UserChoice(randomPlayer, Item.SPOCK));
//    }
//
//    @Test
//    public void testGetSummary() {
//        final GameReport report = new GameReport(newArrayList(game1, game2, game3, game4));
//        final String summary = report.getFullResult();
//        System.out.println(summary);
//        assertThat(summary).isNotNull();
//        assertThat(summary).isNotEmpty();
//    }
//
//    @Test
//    public void testGetFullResult() {
//
//    }
//}
