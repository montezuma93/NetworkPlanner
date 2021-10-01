package library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LibraryService {
    Library library;

    @Autowired
    public LibraryService() {
        System.out.println("Initializing library...");
        library = new Library();
        System.out.println("Library initialized");
    }

    public void addBook(Book book){
        library.books.add(book);
    }

    public List<Book> getBook(){
        return library.books;
    }

}
