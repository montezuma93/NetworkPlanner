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
    int roundSize;

    public PokerGame(List<Player> players, int smallBlind, int bigBlind) {
        int roundSize = bigBlind;
        this.players = players;
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        this.pot = 0;

    }

    public void startGame() {
        allCards = generateCards();
        dealCards();
        setBlinds();
        while (!isGameOver()) {
            // start next round
        }
        System.out.println("GameOver");

    }
    public void setBlinds(){
        players.get(0).dealer = true;
        players.get(1).smallBlind = true;
        players.get(2).bigBlind = true;

    }

    public boolean isGameOver() {
        int amountOfPlayersWithChips = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).chips > 0) {
                amountOfPlayersWithChips++;
            }
        }
        return amountOfPlayersWithChips < 2;
    }
    public void startRounds(){
        for (int i = 0; i < 4; i++){
            startRound();
            dealNextCard();//Neu Karte verteilen!
        }
    }
    public void dealNextCard(){
        for(int i = 0; i < players.size(); i++){
            Player player = players.get(i);
            if(player.gameMember){
                dealLastCard(player);//jeder Player hat eigene Liste (cards)
            }
        }
    }

    public void startRound(){
        //Methode!!
        for(int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            calculateDecision(player);
            //Runde inkrementieren!
        }
        }

    public void calculateDecision(Player player) {
        Decision decision = player.decide();//entscheiden wie viel Chips sind im pot
        switch (decision.decisionType) {
            case FOLD:
                player.gameMember = false;
            case CALL:
                int chipsNeedToBeSet = roundSize - player.chipSetInRound;
                player.chipSetInRound = player.chipSetInRound + chipsNeedToBeSet;
                player.chips -= chipsNeedToBeSet;
                pot += chipsNeedToBeSet;
            case RAISE:
                roundSize = decision.amount; // maximale spielhöhe
                int chipIncremntation = decision.amount - player.chipSetInRound;
                player.chips -= chipIncremntation;
                pot += chipIncremntation;
                player.chipSetInRound = decision.amount;

                // 2 variabilen: 1: menge zu setzen 2:

        }
    }


    public void dealCards() {
        // Jeder Spieler bekommt zufällig 2 Karten
        // Diese Karten müssen aus dem allCards Stapel Entfernt werden
        Collections.shuffle(allCards);
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);     // erster Player usw.
            for (int j = 0; j < 2; j++) { //0 <2 -> true 1<2 -> true 2<2 -false
                dealLastCard(player);
            }
        }
    }

    private void dealLastCard(Player player) {
        Card card = allCards.get(allCards.size() - 1);        // Karte in der Hand
        allCards.remove(card);  // Karte wird aus allCards entfernt
        player.addCard(card);       // Spieler bekommt die Karte
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
