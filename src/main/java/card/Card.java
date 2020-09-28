package card;

import enums.CardSuit;
import enums.CardValue;

public class Card {

    // Attributes
    private CardSuit suit;
    private CardValue value;

    // Constructor
    public Card (CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    // Functions

    // Getter
    public String getSuit() {
        return this.suit.getValue();
    }

    public int getValue() {
        return this.value.getValue();
    }

}
