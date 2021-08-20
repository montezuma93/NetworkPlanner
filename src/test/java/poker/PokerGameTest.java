package poker;

import Poker.Card;
import Poker.Player;
import Poker.PokerGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerGameTest {


    @Test
    public void testGenerateCards() {

        PokerGame pokerGame = createPokerGame(500);
        List<Card> cards = pokerGame.generateCards();
        assertEquals(cards.size(), 52);

    }

    public PokerGameTest() {

    }

    @Test
    public void testDealCards() {
        PokerGame pokerGame = createPokerGame(840);
        pokerGame.allCards = pokerGame.generateCards();
        pokerGame.dealCards();
        assertEquals(pokerGame.allCards.size(), 44);
        for (int i = 0; i < pokerGame.players.size(); i++) {
            assertEquals(pokerGame.players.get(i).cards.size(), 2);
        }
    }

    private PokerGame createPokerGame(int amountOfFirstPlayer) {
        Player player1 = new Player("Niklas", amountOfFirstPlayer);
        Player player2 = new Player("Saskia", 0);
        Player player3 = new Player("Christian", 3000);
        Player player4 = new Player("Sarah", 0);
        PokerGame pokerGame = new PokerGame(List.of(player1, player2, player3, player4), 50, 100);
        return pokerGame;
    }

    @Test
    public void testDealNextCard(){
        PokerGame pokerGame = createPokerGame(4);
        pokerGame.allCards = pokerGame.generateCards();
        pokerGame.dealCards();
        pokerGame.players.get(1).gameMember = false;
        pokerGame.dealNextCard();
        assertEquals(pokerGame.allCards.size(), 41);
        assertEquals(pokerGame.players.get(0).cards.size(),3);
        assertEquals(pokerGame.players.get(1).cards.size(),2);
    }

    @Test
    public void isGameOver() {
        PokerGame pokerGame = createPokerGame(10);
        assertEquals(pokerGame.isGameOver(), false);
        pokerGame = createPokerGame(0);
        assertEquals(pokerGame.isGameOver(), true);
    }
}

