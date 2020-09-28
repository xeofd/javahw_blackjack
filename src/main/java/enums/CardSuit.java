package enums;

public enum CardSuit {

    // Enums
    HEARTS ("hearts"),
    DIAMONDS ("diamonds"),
    SPADES ("spades"),
    CLUBS ("clubs");

    // Constructor
    private final String value;

    CardSuit(String value) {
        this.value = value;
    }

    // Getter
    public String getValue() {
        return this.value;
    }

}
