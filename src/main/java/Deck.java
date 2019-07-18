import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;


    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void create(SuitType suitType, RankType rankType) {
        for(SuitType suit : suitType.values()){
            for(RankType rank : rankType.values()){
                Card card = new Card(suit, rank);
                this.deck.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
    }

    public Card dealCard() {
        if(this.deck.size() > 0){
            return this.deck.remove(0);
        }
        return null;
    }
}
