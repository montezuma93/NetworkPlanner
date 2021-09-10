package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Scene2fx.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/testFX.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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

    private double getRandomNumber() {
        Random r = new Random();
        double randomValue = 0.0 + (1.0 - 0.0) * r.nextDouble();
        return randomValue;
    }

    public void spawnRectangleFruher(ActionEvent event) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("/testFX.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Rectangle rect = new Rectangle(30, 30, 60, 40);  // x,y,size
        rect.setFill(Paint.valueOf("green")); //change color
        root.getChildren().add(rect);  // when root = Pane
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
