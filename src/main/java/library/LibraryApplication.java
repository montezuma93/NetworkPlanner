package library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication extends Application {

    @Autowired
    LibraryController libraryController;

    public static void main(String[] args) {
        Application.launch(LibraryApplication.class, args);
        //launch(args);
        //SpringApplication.run(LibraryApplication.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/scene2fx.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Library");
        stage.show();
    }
}
