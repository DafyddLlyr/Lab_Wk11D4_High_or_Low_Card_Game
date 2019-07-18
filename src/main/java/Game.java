import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Dealer dealer;
    private Deck deck;
    private Card winningCard;

    public Game() {
        this.players = new ArrayList<Player>();
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.winningCard = null;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        this.players.add(player);
    }

    public Card checkCardValues(ArrayList<Card> playerCards) {
        this.winningCard = playerCards.get(0);
        for(int i = 1; i < playerCards.size(); i++) {
            if (playerCards.get(i).getValueFromEnum() == this.winningCard.getValueFromEnum()){
                this.winningCard = null;
            }
            else if (playerCards.get(i).getValueFromEnum() > this.winningCard.getValueFromEnum()){
                this.winningCard = playerCards.get(i);
            }
        }
        return this.winningCard;
    }

    public Player checkWinner() {
        ArrayList<Card> playerCards = new ArrayList<Card>();
        Player winningPlayer = null;
        for (Player player : this.players){
            playerCards.add(player.getCards().get(0));
        }
        this.checkCardValues(playerCards);
        for (Player player : this.players){
            if (player.getCards().get(0) == this.winningCard){
                winningPlayer = player;
            }
        }
        return winningPlayer;
    }
}
