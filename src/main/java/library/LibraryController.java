package library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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

import javax.swing.*;
import java.util.List;
import java.util.Locale;



@Controller
@RequestMapping("library")
public class LibraryController {
    @FXML private AnchorPane LibraryPane;
    @FXML private TextField bookTitle;
    @FXML private TextField bookID;
    @FXML private Button addBookButton;

    @Autowired
    LibraryService libraryService;

    @PostMapping("addBook")
    ResponseEntity<String> addBook(@RequestParam String title, @RequestParam int bookAmount){
        String bookName = title;

        libraryService.addBook(new Book(bookName, bookAmount) );
        return new ResponseEntity<String>("book is added", HttpStatus.CREATED);
    }
    @GetMapping("bookAmountRequest")
    ResponseEntity<String> bookAmountRequest(){
        List<Book> bookList = libraryService.getBooks();
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


    public void addBookAction(ActionEvent addBookEvent) {
        Stage stage = (Stage) LibraryPane.getScene().getWindow();
        AnchorPane libraryPane = (AnchorPane) stage.getScene().getRoot();
        int amountOf = Integer.parseInt(bookID.getText());
        //wo ist book title??
        libraryService.addBook(new Book(bookTitle.getText(), amountOf));
    }

}
