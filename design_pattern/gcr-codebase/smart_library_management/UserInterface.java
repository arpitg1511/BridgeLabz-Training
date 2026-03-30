package smart_library_management;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Singleton
		LibraryCatalog catalog = LibraryCatalog.getInstance();

		// Factory
		User student = UserFactory.createUser("student");
		User faculty = UserFactory.createUser("faculty");
		User librarian = UserFactory.createUser("librarian");

		// Observer
		catalog.registerObserver(student);
		catalog.registerObserver(faculty);
		catalog.registerObserver(librarian);

		// Builder
		Book book = new Book.BookBuilder("Data Structures").addAuthor("Cormen").edition("3rd").genre("Computer Science")
				.publisher("IIT").build();

		// Trigger notification
		catalog.addBook(book);
	}

}