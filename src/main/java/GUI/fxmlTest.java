package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class fxmlTest extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/testFX.fxml"));
            Scene scene = new Scene(root);
            Image bgr = new Image("file:background1.jpg");
            ImageView mv = new ImageView(bgr);

            //root.getChildren().addAll(mv);

            stage.setTitle("Game");
            stage.setScene(scene);//or (new Scene(root, 700, 700));
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
