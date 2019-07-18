import java.util.ArrayList;

public class Dealer {


    public Dealer() {
    }

    public void startGame(Deck deck, ArrayList<Player> players) {
        deck.shuffle();
        for(Player player : players) {
            Card card = deck.dealCard();
            player.addCard(card);
        }
    }
}
