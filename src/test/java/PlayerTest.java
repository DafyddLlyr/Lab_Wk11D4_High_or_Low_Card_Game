import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlayerTest {
    Player player;
    Card card;

    @Before
    public void setUp(){
        player = new Player("Player One");
        card =  new Card(SuitType.HEARTS, RankType.ACE);
    }
    @Test
    public void playerStartsWithNoCards(){
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void playerHasName() {
        assertEquals("Player One", player.getName());
    }

    @Test
    public void playerCanAddCard() {
        player.addCard(card);
        assertEquals(1, player.getCards().size());
    }
}
