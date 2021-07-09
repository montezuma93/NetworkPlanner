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

        PokerGame pokerGame = createPokerGame();
        List<Card> cards = pokerGame.generateCards();
        assertEquals(cards.size(),52);

    }

    public PokerGameTest() {

    }
    @Test
    public void testDealCards(){
       PokerGame pokerGame = createPokerGame();
       pokerGame.allCards = pokerGame.generateCards();
       pokerGame.dealCards();
       assertEquals(pokerGame.allCards.size(),44);
       for (int i = 0; i < pokerGame.players.size(); i++){
           assertEquals(pokerGame.players.get(i).cards.size(),2);
       }
    }
    private PokerGame createPokerGame(){
        Player player1 = new Player("Niklas", 3000);
        Player player2 = new Player("Saskia", 3000);
        Player player3 = new Player("Christian", 3000);
        Player player4 = new Player("Sarah", 3000);
        PokerGame pokerGame = new PokerGame(List.of(player1, player2, player3, player4), 50, 100);
        return pokerGame;
    }
}
