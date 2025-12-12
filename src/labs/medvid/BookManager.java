package labs.medvid;

import java.util.ArrayList;

/**
 * Provides utility methods for filtering and printing books.
 */
public class BookManager {

    public static void printByAuthor(Book[] books, String author) {
        System.out.println("Книги автора: " + author);
        for (Book b : books) {
            if (b.getAuthors().toLowerCase().contains(author.toLowerCase())) {
                System.out.println(b);
            }
        }
    }

    public static void printByPublisher(Book[] books, String publisher) {
        System.out.println("Книги видавництва: " + publisher);
        for (Book b : books) {
            if (b.getPublisher().equalsIgnoreCase(publisher)) {
                System.out.println(b);
            }
        }
    }

    public static void printAfterYear(Book[] books, int year) {
        System.out.println("Книги після року: " + year);
        for (Book b : books) {
            if (b.getYear() > year) {
                System.out.println(b);
            }
        }
    }
}
