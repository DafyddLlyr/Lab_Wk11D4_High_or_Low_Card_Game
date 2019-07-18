import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class DealerTest {
    Dealer dealer;
    Deck deck;
    Player player1;
    Player player2;
    ArrayList<Player> players;
    SuitType suit;
    RankType rank;

    @Before
    public void setUp(){
        dealer = new Dealer();
        deck = new Deck();
        players = new ArrayList<Player>();
        player1 = new Player("Player One");
        player2 = new Player("Player Two");
        players.add(player1);
        players.add(player2);
    }

    @Test
    public void dealCanStartGame(){
        deck.create(suit, rank);
        dealer.startGame(deck, players);
        int remainingCards = 52 - players.size();
        assertEquals(remainingCards, deck.getDeck().size());
        assertEquals(1, player1.getCards().size());
        assertEquals(1, player2.getCards().size());
    }
}
