package library;

public class Book {

    String title;
    int amountOfBooksAvailable;

    public Book(String title, int amountOfBooksAvailable) {
        this.title = title;
        this.amountOfBooksAvailable = amountOfBooksAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Book title='" + title + '\'' +
                ", Amount of books in library=" + amountOfBooksAvailable +
                '}';
    }
}
