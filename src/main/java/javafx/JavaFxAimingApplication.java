package javafx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


@SpringBootApplication
public class JavaFxAimingApplication extends Application {

    Pane root;
    private Timeline timeline;

    AtomicInteger missedCircles = new AtomicInteger(0);
    AtomicInteger clickedCircles = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        root = new Pane();
        Scene scene = new Scene(root, 500, 500);


        Text missedCirclesText = new Text(10, 10, "missedCircles " + missedCircles.get());
        Text clickedCirclesText = new Text(10, 30, "clickedCircles " + clickedCircles.get());
        root.getChildren().add(missedCirclesText);
        root.getChildren().add(clickedCirclesText);
        Circle circle = new Circle(getRandomNumber(), getRandomNumber(), 10);
        circle.setFill(Paint.valueOf("red"));
        root.getChildren().add(circle);
        primaryStage.setTitle("Aiming Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
        circle.setOnMouseClicked(clickEvent -> {
                    clickedCircles.getAndIncrement();
            clickedCirclesText.setText("clickedCircles " + clickedCircles.get());
                    circle.setCenterY(getRandomNumber());
                    circle.setCenterX(getRandomNumber());
                }
        );


            timeline = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
                missedCircles.getAndIncrement();
                missedCirclesText.setText("missedCircles " + missedCircles.get());
                if(missedCircles.get() > 5) {
                    gameOver();
                } else {
                    circle.setCenterY(getRandomNumber());
                    circle.setCenterX(getRandomNumber());
                }
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();


    }

    private void gameOver() {
        root.getChildren().clear();
        Text clickedCirclesText = new Text(30, 300, "clickedCircles " + clickedCircles.get());
        root.getChildren().add(new Text(30, 250, "GAMEOVER"));
        root.getChildren().add(clickedCirclesText);
        timeline.stop();
    }

    private int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(450-50) + 50;
    }

}
