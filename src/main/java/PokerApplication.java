import Poker.Player;
import Poker.PokerGame;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PokerApplication {

    public static void main(String[] args) throws Exception {

        Player player1 = new Player("Niklas", 3000);
        Player player2 = new Player("Saskia", 3000);
        Player player3 = new Player("Christian", 3000);
        Player player4 = new Player("Sarah", 3000);
        PokerGame pokerGame = new PokerGame(List.of(player1, player2, player3, player4), 50, 100);
        //Aufrufen der Karten
        System.out.println(pokerGame.generateCards());

      //  pokerGame.generateCards();

/*


*/


    }
}
