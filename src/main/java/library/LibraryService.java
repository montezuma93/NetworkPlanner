package library;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    Library library;
    LibraryService (){

        System.out.println("Initializing library...");
        library = new Library();
        System.out.println("Library initialized");
    }
    List<Book> getBooks(){
        return library.books;
    }
    void addBook(Book book){
        library.books.add(book);

    }

}
