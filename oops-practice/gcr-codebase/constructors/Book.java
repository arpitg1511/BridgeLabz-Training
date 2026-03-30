import java.util.*;

public class Book {

    // Attributes (encapsulated)
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        // Initializes object with default values
        this.title = "";
        this.author = "";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        // Using 'this' to avoid ambiguity
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    // Main method for testing
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        // Using default constructor
        Book book1 = new Book();
        book1.displayDetails();

        System.out.println();

        // Using parameterized constructor
        Book book2 = new Book(sc.nextLine(), sc.nextLine(), sc.nextDouble());
        book2.displayDetails();
        
        sc.close();
    }
}



