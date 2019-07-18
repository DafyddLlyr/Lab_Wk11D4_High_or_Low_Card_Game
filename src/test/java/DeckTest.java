import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {
    Deck deck;
    SuitType suit;
    RankType rank;
    @Before
    public void setUp(){
        deck = new Deck();
    }
    @Test
    public void deckStartsWithNoCards(){
        assertEquals(0, deck.getDeck().size());
    }

    @Test
    public void deckHas52Cards() {
        deck.create(suit, rank);
        assertEquals(52, deck.getDeck().size());
    }

   @Test
    public void deckCanBeShuffle(){
        deck.create(suit, rank);
        System.out.println(deck.getDeck().get(0).getRank());
        Card originalFirstCard = deck.getDeck().get(0);
        deck.shuffle();
        System.out.println(deck.getDeck().get(0).getRank());
        Card newFirstCard = deck.getDeck().get(0);
        assertNotEquals(originalFirstCard,  newFirstCard);
   }

   @Test
    public void dealingRemoveCardFromDeck(){
        deck.create(suit, rank);
        deck.shuffle();
        deck.dealCard();
        assertEquals(51, deck.getDeck().size());
   }

   @Test
    public void cannotDealEmptyDeck(){
        Card card = deck.dealCard();
        assertEquals(null, card);
   }
}
