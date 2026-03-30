import java.util.*;

/* Custom Exception */
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

/* Book class to store book details */
class BookClass {

    private String title;
    private String author;
    private boolean available;

    // Constructor
    BookClass(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters
    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    boolean isAvailable() {
        return available;
    }

    // Checkout method
    void checkout() throws BookNotAvailableException {
        if (!available) {
            throw new BookNotAvailableException("Book is already checked out");
        }
        available = false;
    }
}

/* Main Library Management System */
public class LibraryManagementCheckout {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array of BookClass objects
        BookClass[] books = {
            new BookClass("Data Structures", "Mark Weiss"),
            new BookClass("Java Programming", "James Gosling"),
            new BookClass("Operating Systems", "Abraham Silberschatz"),
            new BookClass("Computer Networks", "Andrew Tanenbaum"),
            new BookClass("Database Management", "Raghu Ramakrishnan")
        };

        displayBooks(books);

        System.out.print("\nEnter part of the book title to search: ");
        String searchKey = sc.nextLine();

        int index = searchBook(books, searchKey);

        if (index != -1) {
            displayBook(books[index]);

            System.out.print("Do you want to checkout this book? (yes/no): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                try {
                    books[index].checkout();
                    System.out.println("Book checked out successfully.");
                } catch (BookNotAvailableException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("No book found with given title.");
        }

        sc.close();
    }

    // Display all books
    static void displayBooks(BookClass[] books) {
        System.out.println("Library Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " +
                    books[i].getTitle() + " | " +
                    books[i].getAuthor() + " | " +
                    (books[i].isAvailable() ? "Available" : "Checked Out"));
        }
    }

    // Search by partial title
    static int searchBook(BookClass[] books, String key) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().toLowerCase().contains(key.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    // Display single book
    static void displayBook(BookClass book) {
        System.out.println("\nBook Found:");
        System.out.println("Title  : " + book.getTitle());
        System.out.println("Author : " + book.getAuthor());
        System.out.println("Status : " + (book.isAvailable() ? "Available" : "Checked Out"));
    }
}
