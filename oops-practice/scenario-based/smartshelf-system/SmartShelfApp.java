package smartshelf;

public class SmartShelfApp {

    public static void main(String[] args) {

        SmartShelf shelf = new SmartShelf(10);

        shelf.addBook("Java Programming");
        shelf.display();

        shelf.addBook("Algorithms");
        shelf.display();

        shelf.addBook("Data Structures");
        shelf.display();

        shelf.addBook("Operating Systems");
        shelf.display();
    }
}

