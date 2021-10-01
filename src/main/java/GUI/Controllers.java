package GUI;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Controllers {

    @FXML
    Pane pane;
    @FXML
    private TextField xInput;
    @FXML
    private TextField yInput;
    @FXML
    private TextField speedInput;

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Scene2fx.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/testFX.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/

    public void spawnCircle(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Pane pane = (Pane) stage.getScene().getRoot();
        Circle circle = new Circle(60, 60, 20, Paint.valueOf("red"));  // x,y,radius
        pane.getChildren().add(circle);  // when root = Pane
        circle.setOnMouseClicked(clickEvent -> {
                    circle.setFill(Color.color(getRandomNumber(), getRandomNumber(), getRandomNumber()));  // change color when clicked on
                    // clickedCircles.getAndIncrement();
                    // clickedCirclesText.setText("clickedCircles " + clickedCircles.get());
                    // circle.setCenterY(getRandomNumber());
                    // circle.setCenterX(getRandomNumber());
                }
        );
        circle.setOnMouseDragged(mouseDragEvent -> {
                    circle.setCenterX(mouseDragEvent.getX());
                    circle.setCenterY(mouseDragEvent.getY());
                }
        );
    }

    public void spawnRectangle(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Pane pane = (Pane) stage.getScene().getRoot();
        Rectangle rect = new Rectangle(30, 30, 60, 40);
        rect.setFill(Paint.valueOf("green")); //change color
        pane.getChildren().add(rect);

        rect.setOnMouseClicked(clickEvent -> {
                    rect.setFill(Color.color(getRandomNumber(), getRandomNumber(), getRandomNumber()));
                }
        );
        rect.setOnMouseDragged(mouseDragEvent -> {
                    rect.setX(mouseDragEvent.getX());
                    rect.setY(mouseDragEvent.getY());
                }
        );
    }

    public void sammeln(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Pane pane = (Pane) stage.getScene().getRoot();
        double xCoord = Double.parseDouble(xInput.getText());
        double yCoord = Double.parseDouble(yInput.getText());
        double speed = Double.parseDouble(speedInput.getText());
        ObservableList<Node> allObjects = pane.getChildren();

        for (int i = 0; i < allObjects.size(); i++) {
            Node node = allObjects.get(i);
            AnimationTimer animationTimer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (node instanceof Circle) {
                        Circle circle = (Circle) node;
                        moveCircle(xCoord, yCoord, speed, circle);// changed

                        if (checkIfReached(circle.getCenterX(), circle.getCenterY(),
                                xCoord, yCoord) == true) {
                            this.stop();
                        }

                    } else if (node instanceof Rectangle) {
                        Rectangle rectangle = (Rectangle) node;
                        moveRectangle(xCoord, yCoord, speed, rectangle);
                        if (checkIfReached(rectangle.getX(), rectangle.getY(),
                                xCoord, yCoord) == true) {
                            this.stop();
                        }
                    }
                }
            };
            animationTimer.start();
        }
    }

    private boolean checkIfReached(double objectX, double objektY, double xCoord, double yCoord) {
        boolean result = false;
        if (objectX <= xCoord+1 && objectX>= xCoord-1 &&
                objektY <= yCoord+1 && objektY >= yCoord-1) {
            result = true;
        }
        return result;
    }

    private void moveCircle(double zielX, double zielY, double speed, Circle circle) {
        double directionX = zielX - circle.getCenterX(); //richtung
        double directionY = zielY - circle.getCenterY();
        double length = Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));

        directionX = 1 / length * directionX * speed; //normalisierung vom vector
        directionY = 1 / length * directionY * speed;

        circle.setCenterX(circle.getCenterX() + directionX);
        circle.setCenterY(circle.getCenterY() + directionY);
        System.out.println(circle.getCenterX());
        System.out.println(circle.getCenterY());
        if (circle.getCenterX() == zielX && circle.getCenterY() == zielY) {
            return;
        }
    }

    private void moveRectangle(double zielX, double zielY, double speed, Rectangle rect) {
        double directionX = zielX - rect.getX();
        double directionY = zielY - rect.getY();
        double length = Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));

        directionX = 1 / length * directionX * speed;
        directionY = 1 / length * directionY * speed;

        rect.setX(rect.getX() + directionX);
        rect.setY(rect.getY() + directionY);
        if (rect.getX() == zielX && rect.getY() == zielY) {
            return;
        }
    }

   /* private void checkIsMoved() {
        Stage stage = (Stage) pane.getScene().getWindow();
        Pane pane = (Pane) stage.getScene().getRoot();
        ObservableList<Node> allObjects = pane.getChildren();

    }*/

    private double getRandomNumber() {
        Random r = new Random();
        double randomValue = 0.0 + (1.0 - 0.0) * r.nextDouble();
        return randomValue;
    }

    public void spawnRectangleFruher(ActionEvent event) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("/testFX.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Rectangle rect = new Rectangle(30, 30, 60, 40);  // x,y,size
        rect.setFill(Paint.valueOf("green")); //change color
        root.getChildren().add(rect);  // when root = Pane
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
