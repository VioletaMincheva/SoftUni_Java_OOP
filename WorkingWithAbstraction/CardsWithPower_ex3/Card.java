package JavaOOP.WorkingWithAbstraction.CardsWithPower_ex3;

public class Card {
    private CardRank rank;
    private CardSuits suits;
    private int power;

    public Card(CardRank rank, CardSuits suits) {
        this.rank = rank;
        this.suits = suits;
        calculatePower();
    }

    private void calculatePower() {
        this.power = rank.getValue() + suits.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d%n",
                this.rank.name(), this.suits.name(), this.power);
    }
}
