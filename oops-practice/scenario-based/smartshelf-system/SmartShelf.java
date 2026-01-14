package smartshelf;

class SmartShelf {

    private Book[] books;
    private int size;

    SmartShelf(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // add book in real-time (online sorting)
    void addBook(String title) {

        Book newBook = new Book(title);
        books[size] = newBook;

        int i = size - 1;

        // Insertion Sort logic
        while (i >= 0 &&
               books[i].title.compareToIgnoreCase(newBook.title) > 0) {

            books[i + 1] = books[i];
            i--;
        }

        books[i + 1] = newBook;
        size++;

        System.out.println("Added: " + title);
    }

    // display shelf state
    void display() {
        System.out.print("Shelf: ");
        for (int i = 0; i < size; i++) {
            System.out.print(books[i].title + " | ");
        }
        System.out.println();
    }
}

