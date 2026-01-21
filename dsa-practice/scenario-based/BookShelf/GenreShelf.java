import java.util.*;

class GenreShelf {

    private Map<String, LinkedList<BookItem>> genreMap = new HashMap<>();
    private Set<String> bookRegistry = new HashSet<>();

    public void addBook(String genre, BookItem book) {

        if (bookRegistry.contains(book.getKey())) {
            System.out.println("Duplicate book ignored: " + book);
            return;
        }

        genreMap.putIfAbsent(genre, new LinkedList<>());
        genreMap.get(genre).add(book);
        bookRegistry.add(book.getKey());

        System.out.println("Book added to " + genre + " section.");
    }

    public void removeBook(String genre, BookItem book) {

        LinkedList<BookItem> list = genreMap.get(genre);

        if (list == null || !list.removeIf(b -> b.getKey().equals(book.getKey()))) {
            System.out.println("Book not found in " + genre + " section.");
            return;
        }

        bookRegistry.remove(book.getKey());

        if (list.isEmpty()) {
            genreMap.remove(genre);
        }

        System.out.println("Book removed from " + genre + " section.");
    }

    public void displayCatalog() {
        if (genreMap.isEmpty()) {
            System.out.println("Library catalog is empty.");
            return;
        }

        for (Map.Entry<String, LinkedList<BookItem>> entry : genreMap.entrySet()) {
            System.out.println("\nGenre: " + entry.getKey());
            for (BookItem book : entry.getValue()) {
                System.out.println("  - " + book);
            }
        }
    }
}
