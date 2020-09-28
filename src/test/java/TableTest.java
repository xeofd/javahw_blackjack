import card.Card;
import card.Deck;
import enums.CardValue;
import enums.CardSuit;
import org.junit.Before;
import org.junit.Test;
import players.House;
import players.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TableTest {

    // Set up
    private Table table;
    private Deck deck;
    private Player human1;
    private Player human2;
    private House house;
    private Card card1;
    private Card card2;

    @Before
    public void before() {
        deck = new Deck();
        deck.populate();
        deck.shuffle();

        house = new House("Tim");

        table = new Table(house, deck);

        human1 = new Player("ben");
        human2 = new Player("tim");

        card1 = new Card(CardSuit.SPADES, CardValue.KING);
        card2 = new Card(CardSuit.SPADES, CardValue.ACE);
    }

    // Tests

    @Test // Test 1: Test that table has deck
    public void tableHasDeck() {
        assertEquals(52, table.getDeckSize());
    }

    @Test // Test 2: Test that table has no players
    public void tableHasNoPlayers() {
        assertEquals(0, table.getPlayerCount());
    }

    @Test // Test 3: Table can add players
    public void tableCanAddPlayers() {
        table.setPlayer(human1);
        table.setPlayer(human2);

        assertEquals(2, table.getPlayerCount());
    }

    @Test // Test 4: Table can deal cards
    public void tableCanDealCards() {
        table.setPlayer(human1);
        table.setPlayer(human2);

        table.dealToAll();

        assertTrue(human1.hasHand());
    }

    @Test // Test 5: Table can find winner
    public void tableCanFindWinner(){
        table.setPlayer(human1);
        table.setPlayer(human2);

        human1.addToHand(card1);
        human2.addToHand(card2);

        assertEquals("Winner is: ben", table.decideWinner());
    }


    @Test // Test 6: Table can find draw
    public void tableCanFindDraw() {
        table.setPlayer(human1);
        table.setPlayer(human2);

        human1.addToHand(card2);
        human2.addToHand(card2);

        assertEquals("Winner is: It's a draw!", table.decideWinner());
    }

    @Test // Test 7: Table can deal cards on choice
    public void tableCanDealOnChoice() {
        table.setPlayer(human1);
        table.setPlayer(human2);

        table.dealToAll();

        table.dealOnChoice(human1, "hit");

        assertEquals(2, human1.getHandSize());
    }

}