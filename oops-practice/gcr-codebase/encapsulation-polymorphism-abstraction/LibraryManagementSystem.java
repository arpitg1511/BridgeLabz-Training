// interface for reservation related operations
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// abstract base class for all library items
abstract class LibraryItem implements Reservable {

    private final String itemId;
    private String title;
    private String author;

    // sensitive borrower detail (encapsulated)
    private String borrowerName;

    // constructor
    LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // abstract method
    abstract int getLoanDuration();

    // concrete method
    void getItemDetails() {
        System.out.println("Item ID : " + itemId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
    }

    // controlled access to borrower details
    void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    protected String getBorrowerName() {
        return borrowerName;
    }
}

// book item
class Book extends LibraryItem {

    Book(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 14; // days
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// magazine item
class Magazine extends LibraryItem {

    Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem() {
        System.out.println("Magazine reserved");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// DVD item
class DVD extends LibraryItem {

    DVD(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// main class
public class LibraryManagementSystem {

    // polymorphic method (same pattern as previous systems)
    static void printLibraryItemDetails(LibraryItem item) {

        item.getItemDetails();
        System.out.println("Loan Duration : " + item.getLoanDuration() + " days");
        System.out.println("Available     : " + item.checkAvailability());
        item.reserveItem();
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        LibraryItem b = new Book("B101", "Java Basics", "Herbert Schildt");
        LibraryItem m = new Magazine("M201", "Tech Today", "Editorial Team");
        LibraryItem d = new DVD("D301", "Inception", "Christopher Nolan");

        printLibraryItemDetails(b);
        printLibraryItemDetails(m);
        printLibraryItemDetails(d);
    }
}
