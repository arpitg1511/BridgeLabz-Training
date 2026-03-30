import java.util.*;
public class Book {
	
	String title;
	String author;
	double price;
	
	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	void display() {
		System.out.println("Title of the book: " + title);
		System.out.println("Author of the book: " + author);
		System.out.printf("Price of the book: %.2f", price);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Book b = new Book(sc.nextLine(), sc.nextLine(), sc.nextDouble());
		
		b.display();
		
		sc.close();
	}
}
