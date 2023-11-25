import java.util.HashMap;
import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private String refNumber;
    private int pages;

    private boolean borrowed;

    private static HashMap<String, Integer> serials = new HashMap<>();

    public Book(String bookAuthor, String bookTitle, int pages) {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
        refNumber = "";
        String authorCode = author.substring(0, 3).toUpperCase();
        refNumber += authorCode;

        if (!serials.containsKey(authorCode)) {
            serials.put(authorCode, 0);
        }
        int nextSerial = serials.get(authorCode) + 1;
        serials.put(authorCode, nextSerial);
        String serial = Integer.toString(nextSerial);
        if (serial.length() == 1) {
            serial = "00" + serial;
        } else if (serial.length() == 2) {
            serial = "0" + serial;
        }

        refNumber += serial;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public void printAuthor() {
        System.out.println(author);
    }

    public void printTitle() {
        System.out.println(title);
    }

    public String getRefNumber() {
        return refNumber;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void printDetails() {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Pages: " + pages);
        System.out.println("Reference Number:" + refNumber);
        System.out.println("Borrowed: " + borrowed);
    }

    public void printDetails(Boolean b) {
        if (borrowed == true) {
            System.out.println("Author: " + author);
            System.out.println("Title: " + title);
            System.out.println("Pages: " + pages);
            System.out.println("Reference Number:" + refNumber);
            System.out.println("Borrowed: " + borrowed);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && borrowed == book.borrowed && Objects.equals(author, book.author) && Objects.equals(title, book.title) && Objects.equals(refNumber, book.refNumber);
    }


}
