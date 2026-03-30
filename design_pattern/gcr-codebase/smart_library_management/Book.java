package smart_library_management;

import java.util.ArrayList;
import java.util.List;

class Book {
	private String title;
	private List<String> authors;
	private String edition;
	private String genre;
	private String publisher;

	private Book(BookBuilder book) {
		this.title = book.title;
		this.authors = book.authors;
		this.edition = book.edition;
		this.genre = book.genre;
		this.publisher = book.publisher;
	}

	public String getTitle() {
		return title;
	}

	public static class BookBuilder {
		private String title;
		private List<String> authors;
		private String edition;
		private String genre;
		private String publisher;

		public BookBuilder(String title) {
			this.title = title;
			authors = new ArrayList<String>();
		}

		public BookBuilder addAuthor(String author) {
			authors.add(author);
			return this;
		}

		public BookBuilder edition(String edition) {
			this.edition = edition;
			return this;
		}

		public BookBuilder genre(String genre) {
			this.genre = genre;
			return this;
		}

		public BookBuilder publisher(String publisher) {
			this.publisher = publisher;
			return this;
		}

		public Book build() {
			return new Book(this);
		}
	}
}