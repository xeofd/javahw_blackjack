package players;

import card.Card;

import java.util.ArrayList;

public class Human {

    // Attributes
    private String name;
    private ArrayList<Card> hand;

    // Constructor
    public Human(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    // Methods

    // Getters & Setters

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getHandSize() {
        return this.hand.size();
    }

    public Card getHandAt(int index) {
        return this.hand.get(index);
    }

    public void addToHand(Card card) {
        this.hand.add(card);
    }

    public int getScore() {
        int total = 0;

        for (Card card : this.hand) {
            total += card.getValue();
        }

        return total;
    }

    // Functional

    public boolean chooseHit() {
        return true;
    }

    public boolean choseStick() {
        return false;
    }

    public boolean hasHand() {
        if (this.hand.size() > 0) {
            return true;
        }

        return false;
    }

}
