import card.Card;
import enums.CardSuit;
import enums.CardValue;
import org.junit.Before;
import org.junit.Test;
import players.Player;

import static org.junit.Assert.assertEquals;

public class HumanTest {

    // Set up

    private Player human;
    private Card card;

    @Before
    public void before() {
        human = new Player("Ben");
        card = new Card(CardSuit.HEARTS, CardValue.ACE);
    }

    // Tests

    @Test // Test 1: Player has name
    public void playerHasName() {
        assertEquals("Ben", human.getName());
    }

    @Test // Test 2: Player has no card to begin
    public void playerHasNoCard() {
        assertEquals(0, human.getHandSize());
    }

    @Test // Test 3: Player can have a card set
    public void playerCanBeGivenCard() {
        human.addToHand(card);
        assertEquals(card.getSuit(), human.getHandAt(0).getSuit());
    }

}
