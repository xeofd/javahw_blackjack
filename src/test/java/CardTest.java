import card.Card;
import enums.CardValue;
import enums.CardSuit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CardTest {

    // Set up
    private Card card;

    @Before
    public void before() {
        card = new Card(CardSuit.SPADES, CardValue.FIVE);
    }

    // Tests

    @Test // Test 1: Hand.Card has a value
    public void cardHasValue() {
        assertEquals(5, card.getValue());
    }

    @Test // Test 2: Hand.Card has a suit
    public void cardHasSuit() {
        assertEquals("spades", card.getSuit());
    }
}
