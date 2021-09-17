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
                "Title='" + title + '\'' +
                ", Amount of books available=" + amountOfBooksAvailable +
                '}';
    }
}
