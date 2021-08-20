package Poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int chips;
    int chipSetInRound;
    boolean dealer;
    boolean smallBlind;
    boolean bigBlind;
    public boolean gameMember;
    public List<Card> cards;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        this.chipSetInRound = 0;
        this.dealer = false;
        this.cards = new ArrayList<>();
        this.bigBlind = false;
        this.smallBlind = false;
        this.gameMember = true;
    }
    public void addCard(Card card){
        this.cards.add(card);
    }
    public Decision decide(){
        return new Decision(DecisionType.CALL);
    }

}

