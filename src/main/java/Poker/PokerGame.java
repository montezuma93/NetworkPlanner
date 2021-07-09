package Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerGame {
    public List<Player> players;
    List<Combination> combinations;
    public List<Card> allCards;
    List<Card> shownCards;
    int pot;
    int smallBlind;
    int bigBlind;

    public PokerGame(List<Player> players, int smallBlind, int bigBlind) {
        this.players = players;
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
    }

    public void startGame() {
        allCards = generateCards();
        dealCards();
        while (!isGameOver()) {
        }
    }

    public boolean isGameOver() { // Berechnung fehlt noch
        return true;
    }


    public void dealCards() {
        // Jeder Spieler bekommt zufällig 2 Karten
        // Diese Karten müssen aus dem allCards Stapel Entfernt werden
        Collections.shuffle(allCards);
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);     // erster Player usw.
            for (int j = 0; j < 2; j++) { //0 <2 -> true 1<2 -> true 2<2 -false
                Card card = allCards.get(allCards.size() - 1);        // Karte in der Hand
                allCards.remove(card);  // Karte wird aus allCards entfernt
                player.addCard(card);       // Spieler bekommt die Karte
            }
        }
    }

    public List<Card> generateCards() {
        List<Card> cards = new ArrayList<>();
        List<Color> colors = Arrays.asList(Color.values());
        List<Number> numbers = Arrays.asList(Number.values());

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < colors.size(); j++) {
                Card card = new Card(colors.get(j), numbers.get(i));
                cards.add(card);
            }
        }
        return cards;
    }
}
