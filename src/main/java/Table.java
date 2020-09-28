import card.Card;
import players.House;
import players.Player;
import card.Deck;

import java.util.ArrayList;

public class Table {

    // Attributes
    private ArrayList<Player> players;
    private House house;
    private Deck deck;
    private ArrayList<Integer> playerScores;
    private int houseScore;

    // Constructor
    public Table(House house, Deck deck) {
        this.house = house;
        this.deck = deck;
        this.players = new ArrayList<>();
        this.playerScores = new ArrayList<>();
        this.houseScore = 0;
    }

    // Methods

    // Getters & Setters
    public ArrayList getPlayers() {
        return this.players;
    }

    public int getPlayerCount() {
        return this.players.size();
    }

    public House getHouse() {
        return this.house;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public int getDeckSize() {
        return this.deck.deckSize();
    }

    public Player getPlayerAt(int index) {
        return this.players.get(index);
    }

    public void setPlayer(Player player) {
        this.players.add(player);
    }

    // Functional

    public void dealToAll() {
        for (Player player : this.players) {
            house.dealToPlayer(player, this.deck);
        }

        house.dealToSelf(this.deck);
    }

    public void dealOnChoice(Player player, String choice) {

        if (player.getName() == "house") {
            int total = 0;

            for (Card card : house.getHand()) {
                total += card.getValue();
            }

            if (total <= 16) {
                house.dealToSelf(deck);
            }

        } else if (choice == "hit") {
            house.dealToPlayer(player, deck);
        }
    }

    public String decideWinner() {
        int record = 0;
        int total;
        String winner = "";

        for (Player player : this.players) {

            total = 0;

            for (Card card : player.getHand()) {
                total += card.getValue();
                if (total > record & total < 21) {
                    record = card.getValue();
                    winner = player.getName();
                } else if (total == record) {
                    winner = "It's a draw!";
                }
            }
        }

        return "Winner is: " + winner;
    }

}
