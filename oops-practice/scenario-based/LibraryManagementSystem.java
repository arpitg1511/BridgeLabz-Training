import java.util.*;

/* Book class to store book details */
class Book {

    private String title;
    private String author;
    private boolean available;

    // Constructor to initialize book details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true; // book is available by default
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Method to checkout book
    public void checkout() {
        available = false;
    }
}

/* Main Library Management System */
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array of Book objects
        Book[] books = {
            new Book("Java Programming", "James Gosling"),
            new Book("Data Structures", "Mark Weiss"),
            new Book("Operating Systems", "Abraham Silberschatz"),
            new Book("Computer Networks", "Andrew Tanenbaum"),
            new Book("Database Management", "Raghu Ramakrishnan")
        };

        // Display all books
        displayBooks(books);

        System.out.print("\nEnter part of the book title to search: ");
        String searchKey = sc.nextLine();

        // Search for the book
        int index = searchBook(books, searchKey);

        if (index != -1) {
            System.out.println("\nBook Found:");
            displayBook(books[index]);

            // Checkout option
            if (books[index].isAvailable()) {
                System.out.print("Do you want to checkout this book? (yes/no): ");
                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("yes")) {
                    books[index].checkout();
                    System.out.println("Book checked out successfully.");
                }
            } else {
                System.out.println("This book is already checked out.");
            }
        } else {
            System.out.println("No book found with given title.");
        }

        sc.close();
    }

    // Method to display all books
    static void displayBooks(Book[] books) {
        System.out.println("Library Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " +
                    books[i].getTitle() + " | " +
                    books[i].getAuthor() + " | " +
                    (books[i].isAvailable() ? "Available" : "Checked Out"));
        }
    }

    // Method to search book by partial title
    static int searchBook(Book[] books, String key) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().toLowerCase().contains(key.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    // Method to display single book details
    static void displayBook(Book book) {
        System.out.println("Title  : " + book.getTitle());
        System.out.println("Author : " + book.getAuthor());
        System.out.println("Status : " + (book.isAvailable() ? "Available" : "Checked Out"));
    }
}
