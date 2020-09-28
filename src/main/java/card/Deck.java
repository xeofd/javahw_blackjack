package card;

import enums.CardSuit;
import enums.CardValue;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // Attributes
    private ArrayList<Card> cards;

    // Constructor
    public Deck() {
        this.cards = new ArrayList<>();
    }

    // Methods

    public ArrayList getDeck() {
        return this.cards;
    }

    public int deckSize() {
        return this.cards.size();
    }

    public Card getCardAt(int index) {
        return this.cards.get(index);
    }

    public void populate() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                this.cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card deal() {
        return this.cards.remove(0);
    }

}
