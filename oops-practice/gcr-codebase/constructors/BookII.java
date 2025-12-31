import java.util.Scanner;

public class BookII {

    // Attributes
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Parameterized constructor
    public BookII(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + (available ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input
        String title = sc.nextLine();
        String author = sc.nextLine();
        double price = sc.nextDouble();
        boolean available = sc.nextBoolean();

        BookII book = new BookII(title, author, price, available);

        // Display before borrowing
        book.displayBookDetails();

        // Borrow the book
        book.borrowBook();

        // Display after borrowing
        book.displayBookDetails();

        sc.close();
    }
}
