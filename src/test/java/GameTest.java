import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class GameTest {
    Game game;

    @Before
    public void setUp(){
        game = new Game();
    }
    @Test
    public void gameStartsWithZeroPlayers(){
        assertEquals(0, game.getPlayers().size());
    }
    @Test
    public void gameStartsWithDealer(){
        assertNotEquals(null, game.getDealer());
    }

    @Test
    public void gameStartsWithDeck(){
        assertNotEquals(null, game.getDeck());
    }

    @Test
    public void gameAddPlayers(){
        game.addPlayer("Player One");
        assertEquals(1, game.getPlayers().size());
    }

    @Test
    public void gameCanCheckCardValues(){
        Card lowCard = new Card(SuitType.HEARTS, RankType.ACE);
        Card highCard = new Card(SuitType.HEARTS, RankType.KING);
        ArrayList<Card> testCards = new ArrayList<Card>();
        testCards.add(lowCard);
        testCards.add(highCard);
        Card result = game.checkCardValues(testCards);
        assertEquals(highCard, result);
    }

    @Test
    public void nullReturnedWhenCardsAreEqual() {
        Card lowCard = new Card(SuitType.HEARTS, RankType.ACE);
        Card highCard = new Card(SuitType.CLUBS, RankType.ACE);
        ArrayList<Card> testCards = new ArrayList<Card>();
        testCards.add(lowCard);
        testCards.add(highCard);
        Card result = game.checkCardValues(testCards);
        assertEquals(null, result);
    }

    @Test
    public void gameCanCheckWinCondition() {
        game = new Game();
        game.addPlayer("Player One");
        game.addPlayer("Player Two");
        Card lowCard = new Card(SuitType.HEARTS, RankType.ACE);
        Card highCard = new Card(SuitType.HEARTS, RankType.KING);
        game.getPlayers().get(0).getCards().add(lowCard);
        game.getPlayers().get(1).getCards().add(highCard);
        Player winner = game.checkWinner();
        assertEquals("Player Two", winner.getName());
    }
}
