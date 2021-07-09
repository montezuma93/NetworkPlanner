package Poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int chips;
    boolean dealer;
    public List<Card> cards;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        this.dealer = false;
        this.cards = new ArrayList<>();
    }
    public void addCard(Card card){
        this.cards.add(card);
    }
}
