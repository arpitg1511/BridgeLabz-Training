import java.util.Scanner;

// Superclass
class BookIII {
    public String ISBN;        // public: accessible everywhere
    protected String title;    // protected: accessible in subclass
    private String author;     // private: accessible only in this class

    // Parameterized constructor
    public BookIII(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter for author (private access)
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass demonstrating access to ISBN and title
class EBook extends BookIII {
    private String format; // e.g., PDF, EPUB

    public EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    public void displayEBookDetails() {
        // Can access public ISBN directly
        System.out.println("E-Book ISBN: " + ISBN);

        // Can access protected title directly
        System.out.println("E-Book Title: " + title);

        // Cannot access private author directly; use getter
        System.out.println("E-Book Author: " + getAuthor());

        System.out.println("Format: " + format);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Book
        System.out.println("Enter ISBN, Title, and Author for book:");
        String isbn = sc.nextLine();
        String title = sc.nextLine();
        String author = sc.nextLine();

        BookIII book = new BookIII(isbn, title, author);
        System.out.println("\n--- Book Details ---");
        book.displayBookDetails();

        // Input for EBook
        System.out.println("\nEnter ISBN, Title, Author, and Format for E-Book:");
        String eIsbn = sc.nextLine();
        String eTitle = sc.nextLine();
        String eAuthor = sc.nextLine();
        String format = sc.nextLine();

        EBook ebook = new EBook(eIsbn, eTitle, eAuthor, format);
        System.out.println("\n--- E-Book Details ---");
        ebook.displayEBookDetails();

        sc.close();
    }
}
