package players;

import card.Deck;

public class House extends Human {

    // Constructor
    public House(String name) {
        super(name);
    }

    // Methods

    public void dealToPlayer(Player player, Deck deck) {
        player.addToHand(deck.deal());
    }

    public void dealToSelf(Deck deck) {
        this.getHand().add(deck.deal());
    }

}
