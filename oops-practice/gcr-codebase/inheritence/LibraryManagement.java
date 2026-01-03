import java.util.*;


//Base class representing a Book
class Book {
    String title;
    int publicationYear;

    // Constructor to initialize book details
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Displays basic book information
    void displayInfo() {
        System.out.println("Title of Book : " + title);
        System.out.println("Publication Year : " + publicationYear);
    }
}

// Author class inherits properties of Book
class Author extends Book {
    String name;
    String bio;

    // Constructor initializes both book and author details
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); // initialize Book data
        this.name = name;
        this.bio = bio;
    }

    // Overridden method to display author + book information
    @Override
    void displayInfo() {
        System.out.println("Name of Author : " + name);
        System.out.println("Bio : " + bio);
        super.displayInfo(); // reuse Book's display logic
    }
}

public class LibraryManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for book details
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Publication Year: ");
        int year = sc.nextInt();
        sc.nextLine(); // clears buffer after nextInt()

        // Taking input for author details
        System.out.print("Enter Author Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Bio: ");
        String bio = sc.nextLine();

        // Parent reference pointing to child object ()
        Book b = new Author(title, year, name, bio);
        
        // Method call resolved at runtime
        b.displayInfo();

        sc.close();
    }
}
