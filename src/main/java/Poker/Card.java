package Poker;

public class Card {
    Color color;
    Number number;

    Card(Color color, Number number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", number=" + number +
                '}';
    }
}
