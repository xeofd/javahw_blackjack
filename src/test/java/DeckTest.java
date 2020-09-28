import card.Card;
import card.Deck;
import enums.CardValue;
import enums.CardSuit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {

    // Set up
    private Deck deck;

    @Before
    public void before() {
        deck = new Deck();
    }

    // Tests

    @Test // Test 1: Check deck has no cards to begin
    public void deckHasNoCards() {
        assertEquals(0, deck.deckSize());
    }

    @Test // Test 2: Hand.Deck has 52 cards after populate
    public void deckCanBePopulated() {
        deck.populate();
        assertEquals(52, deck.deckSize());
    }

    @Test // Test 3: After shuffle first card is not ace of hearts
    public void canBeShuffledFirstCardCheck() {
        Card initial = new Card(CardSuit.HEARTS, CardValue.ACE);
        deck.populate();
        deck.shuffle();
        assertNotSame(initial.getValue(), deck.getCardAt(0).getValue());
        assertNotEquals(initial.getSuit(), deck.getCardAt(0).getSuit());
    }

    @Test // Test 4: After shuffle, 20th card is not seven of spades
    public void canBeShuffled20thCardCheck() {
        Card initial = new Card(CardSuit.SPADES, CardValue.SEVEN);
        deck.populate();
        deck.shuffle();
        assertNotSame(initial.getValue(), deck.getCardAt(19).getValue());
        assertNotEquals(initial.getSuit(), deck.getCardAt(19).getSuit());
    }

    @Test // Test 5: After shuffle, 52nd card is not king of clubs
    public void canBeShuffled52ndCardCheck() {
        Card initial = new Card(CardSuit.CLUBS, CardValue.KING);
        deck.populate();
        deck.shuffle();
        assertNotSame(initial.getValue(), deck.getCardAt(51).getValue());
        assertNotEquals(initial.getValue(), deck.getCardAt(51).getValue());
    }

    @Test // Test 6: Can deal cards
    public void canDealCards() {
        // Populate and shuffle
        deck.populate();
        deck.shuffle();

        // Remove a card and get the full deck
        Card removed = deck.deal();

        ArrayList cards = deck.getDeck();

        assertEquals(51, deck.deckSize());
        assertFalse(cards.contains(removed));
    }

}
