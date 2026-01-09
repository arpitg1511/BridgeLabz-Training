import java.util.Scanner;

class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    BookNode(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }

    void display() {
        System.out.println(
            "Book Title : " + bookTitle +
            "\nAuthor : " + author +
            "\nGenre : " + genre +
            "\nBook ID : " + bookId +
            "\nAvailable : " + (isAvailable ? "Yes" : "No")
        );
        System.out.println("----------------------");
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initial books
        BookNode head = new BookNode("1984", "George Orwell", "Dystopian", 101, true);
        BookNode tail = head;

        // Adding more books
        tail = addAtLast(tail, "Brave New World", "Aldous Huxley", "Dystopian", 102, true);
        head = addAtBeginning(head, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 103, true);
        head = addAtPosition(head, tail, "Fahrenheit 451", "Ray Bradbury", "Dystopian", 104, true, 2);

        System.out.println("All Books in Library:");
        displayFromBeginning(head);

        // Searching
        System.out.println("Search by Book Title '1984':");
        BookNode foundTitle = searchByBookTitle(head, "1984");
        if (foundTitle != null) foundTitle.display();

        System.out.println("Search by Author 'Ray Bradbury':");
        BookNode foundAuthor = searchByAuthor(head, "Ray Bradbury");
        if (foundAuthor != null) foundAuthor.display();

        // Update availability
        System.out.println("Updating availability of Book ID 104 to false:");
        updateAvailabilityByBookId(head, 104, false);

        // Delete a book
        System.out.println("Deleting Book ID 102:");
        head = deleteByBookId(head, 102);

        // Display final list
        System.out.println("Final Library:");
        displayFromBeginning(head);

        // Display in reverse
        tail = head;
        while (tail != null && tail.next != null) tail = tail.next;

        System.out.println("Display From Last:");
        displayFromLast(tail);

        // Count total books
        System.out.println("Total books in library: " + countBooks(head));

        sc.close();
    }

    // Add at beginning
    static BookNode addAtBeginning(BookNode head, String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) return newNode;

        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    // Add at end
    static BookNode addAtLast(BookNode tail, String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        if (tail == null) return newNode;

        tail.next = newNode;
        newNode.prev = tail;
        return newNode;
    }

    // Add at specific position (1-based)
    static BookNode addAtPosition(BookNode head, BookNode tail, String bookTitle, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 1 || head == null) {
            return addAtBeginning(head, bookTitle, author, genre, bookId, isAvailable);
        }

        BookNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            addAtLast(temp, bookTitle, author, genre, bookId, isAvailable);
            return head;
        }

        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;

        return head;
    }

    // Delete by Book ID
    static BookNode deleteByBookId(BookNode head, int bookId) {
        if (head == null) return null;

        if (head.bookId == bookId) {
            BookNode newHead = head.next;
            if (newHead != null) newHead.prev = null;
            return newHead;
        }

        BookNode temp = head;
        while (temp.next != null && temp.next.bookId != bookId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Book not found");
        } else {
            temp.next = temp.next.next;
            if (temp.next != null) temp.next.prev = temp;
        }

        return head;
    }

    // Search by Book Title
    static BookNode searchByBookTitle(BookNode head, String title) {
        while (head != null) {
            if (head.bookTitle.equalsIgnoreCase(title)) return head;
            head = head.next;
        }
        return null;
    }

    // Search by Author
    static BookNode searchByAuthor(BookNode head, String author) {
        while (head != null) {
            if (head.author.equalsIgnoreCase(author)) return head;
            head = head.next;
        }
        return null;
    }

    // Update availability by Book ID
    static void updateAvailabilityByBookId(BookNode head, int bookId, boolean isAvailable) {
        while (head != null) {
            if (head.bookId == bookId) {
                head.isAvailable = isAvailable;
                System.out.println("Availability updated successfully");
                return;
            }
            head = head.next;
        }
        System.out.println("Book not found");
    }

    // Display from beginning
    static void displayFromBeginning(BookNode head) {
        while (head != null) {
            head.display();
            head = head.next;
        }
    }

    // Display from last
    static void displayFromLast(BookNode tail) {
        while (tail != null) {
            tail.display();
            tail = tail.prev;
        }
    }

    // Count total books
    static int countBooks(BookNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
