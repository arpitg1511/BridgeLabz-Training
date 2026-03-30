package library_management_system;

public class Book {

    private final int bookId;
    private String title;
    private boolean isAvailable = true;

    Book(int id, String title) {
        this.bookId = id;
        this.title = title;
    }

    int getId() {
        return bookId;
    }

    String getTitle() {
        return title;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    void issue() {
        isAvailable = false;
    }

    void returned() {
        isAvailable = true;
    }
}

