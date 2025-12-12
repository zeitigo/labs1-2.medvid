package labs.medvid;

/**
 * Represents a book entity with basic metadata.
 */
public class Book {
    private int id;
    private String title;
    private String authors;
    private String publisher;
    private int year;
    private int pages;
    private double price;
    private String cover;

    public Book(int id, String title, String authors, String publisher,
                int year, int pages, double price, String cover) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.cover = cover;
    }

    public String getAuthors() { return authors; }
    public String getPublisher() { return publisher; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return id + ". " + title + " | " + authors + " | " +
                publisher + " | " + year + " | " + pages +
                " стор. | " + price + " грн | " + cover;
    }
}
