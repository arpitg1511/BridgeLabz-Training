import java.util.*;

public class Book {

	// Static variable: shared among all Book objects
	static String libraryName = "Oxford";
	
	// Instance variables: unique for each Book object
	String title;
	String author;

	// Final variable: ISBN cannot be changed once assigned
	final String ISBN;
	
	// Constructor to initialize Book details
	// Using 'this' to resolve ambiguity between instance variables and parameters
	public Book(String title, String author, String ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	
	// Static method: can be called without creating an object
	static void displayLibraryName() {
		System.out.println("Library Name : " + libraryName);
	}
	
	// Method to display book details
	// Accepts Object type to demonstrate instanceof usage
	void displayDetails(Object obj) {

		// Check whether the passed object is of type Book
		if (!(obj instanceof Book)) {
			System.out.println("Object is not an object of Book");
			return;
		}
		
		// Display instance variables of the Book object
		System.out.println("Title of Book : " + title);
		System.out.println("Author of Book : " + author);
		System.out.println("ISBN number : " + ISBN);
	}
	
	public static void main(String[] args) {

		// Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		// Creating Book object using constructor
		Book b = new Book(sc.nextLine(), sc.nextLine(), sc.next());
		
		// Calling static method using class name
		Book.displayLibraryName();
		
		// Calling instance method using object reference
		b.displayDetails(b);
		
		// Closing scanner to prevent resource leak
		sc.close();
	}
}
