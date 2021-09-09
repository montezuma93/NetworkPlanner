import Poker.Player;
import Poker.PokerGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class PokerApplication extends Application {

    public static void main(String[] args) throws Exception {

        launch(args);

        Player player1 = new Player("Niklas", 3000);
        Player player2 = new Player("Saskia", 3000);
        Player player3 = new Player("Christian", 3000);
        Player player4 = new Player("Sarah", 3000);
        PokerGame pokerGame = new PokerGame(List.of(player1, player2, player3, player4), 50, 100);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("poker/view/RootLayout.fxml")));
        primaryStage.setTitle("Loading Game");
        primaryStage.setScene(new Scene(root, 300,275));
        primaryStage.show();
    }
}
