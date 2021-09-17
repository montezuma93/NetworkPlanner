package library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;



@Controller
@RequestMapping("library")
public class LibraryController {

    @FXML Pane pane;
    @FXML private TextField bookTitle;
    @FXML private TextField bookAmount;
    @FXML private TextArea showBooksArea;
    @FXML private Button addBookButton;
    @FXML private Button showBooksButton;

    //@Autowired
    LibraryService libraryService = new LibraryService();  //what I've changed

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/testFX.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @PostMapping("addBook")
    ResponseEntity<String> addBook(@RequestParam String title, @RequestParam int amount){
        String bookName = title;
        int bookAmount = amount;
        libraryService.addBook(new Book(bookName, bookAmount));
        return new ResponseEntity<String>("book is added", HttpStatus.CREATED);
    }

    @GetMapping("showBookAmount")
    ResponseEntity<String> bookAmountRequest(){
        List<Book> bookList = libraryService.getBook();
        return new ResponseEntity<String>(bookList.toString(), HttpStatus.CREATED);
    }

    @GetMapping("hello")
    ResponseEntity<String> helloLibrary() {
        return new ResponseEntity<String>("hello back", HttpStatus.OK);
    }

    @GetMapping("ping-pong")
    ResponseEntity<String> pingPongLibrary(@RequestParam String pingOrPong) {
        String body;
        if (pingOrPong.equalsIgnoreCase("ping")) {
            body = "pong";
        } else if (pingOrPong.equalsIgnoreCase("pong")) {
            body = "ping";
        } else {
            body = "No Idea what u are saying";
            return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }

    @FXML
    private void addBookAction(ActionEvent addBookEvent) throws IOException{
        Stage stage = (Stage) pane.getScene().getWindow();
        Pane pane = (Pane) stage.getScene().getRoot();

        String bTitle = bookTitle.getText();
        int bAmount = Integer.parseInt(bookAmount.getText());
        libraryService.addBook(new Book(bTitle, bAmount));
        //resultField.setText("Added!");
        bookTitle.clear();
        bookAmount.clear();
    }

    @FXML
    private void showBooks(ActionEvent showBooksEvent) throws IOException{
        Stage stage = (Stage) pane.getScene().getWindow();
        Pane pane = (Pane) stage.getScene().getRoot();

        List<Book> availableBooks = libraryService.getBook();
        System.out.println(Arrays.toString(availableBooks.toArray()));

        for (int i=0; i<availableBooks.size(); i++){
            showBooksArea.appendText(availableBooks.get(i).toString() + "\n");
        }
    }
}
