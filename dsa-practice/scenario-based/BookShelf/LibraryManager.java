public class LibraryManager {
    public static void main(String[] args) {

        GenreShelf shelf = new GenreShelf();

        BookItem b1 = new BookItem("1984", "George Orwell");
        BookItem b2 = new BookItem("Animal Farm", "George Orwell");
        BookItem b3 = new BookItem("The Hobbit", "J.R.R. Tolkien");

        shelf.addBook("Dystopian", b1);
        shelf.addBook("Dystopian", b2);
        shelf.addBook("Fantasy", b3);

        shelf.addBook("Fantasy", b3); // duplicate test

        shelf.displayCatalog();

        shelf.removeBook("Dystopian", b2);
        shelf.displayCatalog();
    }
}
