package library;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    ArrayList<Book> books;

    Library() {
        this.books = new ArrayList<>();
    }
}
