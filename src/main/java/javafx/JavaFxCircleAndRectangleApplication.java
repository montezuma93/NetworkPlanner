package javafx;

import javafx.animation.AnimationTimer;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaFxCircleAndRectangleApplication extends Application {

    double speed = 0.1;
    Rectangle rectangle;
    Circle circle;
    Pane root;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        circle = new Circle(500, 500, 10);
        circle.setFill(Paint.valueOf("red"));
        rectangle = new Rectangle(20, 20, 30, 30);
        rectangle.setFill(Paint.valueOf("blue"));

        root = new Pane();
        Scene scene = new Scene(root, 1000, 750);
        root.getChildren().add(rectangle);
        root.getChildren().add(circle);
        primaryStage.setTitle("Circle and Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(keyEvent -> {
            System.out.println(keyEvent.getCode());
            System.out.println(rectangle.getX());
            System.out.println(rectangle.getY());
            switch (keyEvent.getCode()) {
                case RIGHT:
                    if (rectangle.getX() + rectangle.getWidth() < scene.getWidth()) {
                        rectangle.setX(rectangle.getX() + 2);
                    }
                    break;
                case LEFT:
                    if (rectangle.getX() > 2) {

                        rectangle.setX(rectangle.getX() - 2);
                    }
                    break;
                case DOWN:
                    if (rectangle.getY() + rectangle.getHeight() < scene.getHeight()) {
                        rectangle.setY(rectangle.getY() + 2);
                    }
                    break;
                case UP:
                    if (rectangle.getY() > 2) {
                        rectangle.setY(rectangle.getY() - 2);
                        break;
                    }

                case PLUS:
                    speed = speed + 0.1;
                    break;
                case MINUS:
                    speed = Math.min(0, speed - 0.1);
                    break;

            }
            checkIfGameIsOver();
        });

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveCircle();
            }
        };
        animationTimer.start();


    }

    /**
     * @see "https://www.geeksforgeeks.org/check-if-any-point-overlaps-the-given-circle-and-rectangle/"
     */
    private void checkIfGameIsOver() {

        double Xn = Math.max(rectangle.getX(), Math.min(circle.getCenterX(), rectangle.getX() + rectangle.getWidth()));
        double Yn = Math.max(rectangle.getY(), Math.min(circle.getCenterY(), rectangle.getY() + rectangle.getHeight()));

        double Dx = Xn - circle.getCenterX();
        double Dy = Yn - circle.getCenterY();
        if ((Dx * Dx + Dy * Dy) <= circle.getRadius() * circle.getRadius()) {
            root.getChildren().clear();
            root.getChildren().add(new Text(500, 375, "GAMEOVER"));
        }
    }

    private void moveCircle() {
        double directionX = rectangle.getX() - circle.getCenterX();
        double directionY = rectangle.getY() - circle.getCenterY();
        double length = Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));

        directionX = 1 / length * directionX * speed;
        directionY = 1 / length * directionY * speed;

        circle.setCenterX(circle.getCenterX() + directionX);
        circle.setCenterY(circle.getCenterY() + directionY);
        checkIfGameIsOver();
    }

}
