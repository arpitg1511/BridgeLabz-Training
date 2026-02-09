package smart_library_management;

import java.util.ArrayList;
import java.util.List;

class LibraryCatalog {
	private static LibraryCatalog instance;
	private List<Book> books = new ArrayList<Book>();
	private List<Observer> observers = new ArrayList<Observer>();

	private LibraryCatalog() {
	}

	public static synchronized LibraryCatalog getInstance() {
		if (instance == null) {
			instance = new LibraryCatalog();
		}
		return instance;
	}

	public void addBook(Book book) {
		books.add(book);
		notifyAll(book);
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyAll(Book book) {
		for (Observer o : observers) {
			o.notify(book);
		}
	}
}