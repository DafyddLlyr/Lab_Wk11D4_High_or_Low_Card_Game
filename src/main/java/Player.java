import java.util.ArrayList;

public class Player {

    private ArrayList<Card> cards;
    private String name;

    public Player(String name) {
        this.cards = new ArrayList<Card>();
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public String getName() {
        return this.name;
    }
}
