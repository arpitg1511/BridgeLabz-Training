import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Book {
	
	String name;
	String genre;
	int numberOfPages;
	
	public Book(String name, String genre, int numberOfPages) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.genre = genre;
		this.numberOfPages = numberOfPages;
		
	}
}

public class LibraryBookStatistics {
	
	public static void main(String[] args) {
		
		List<Book> listOfBooks = Arrays.asList(
			    new Book("The Alchemist", "Fiction", 208),
			    new Book("1984", "Fiction", 328),
			    new Book("To Kill a Mockingbird", "Fiction", 281),

			    new Book("Clean Code", "Programming", 464),
			    new Book("Effective Java", "Programming", 416),
			    new Book("Introduction to Algorithms", "Programming", 1312),

			    new Book("Atomic Habits", "Self-Help", 320),
			    new Book("Deep Work", "Self-Help", 304),

			    new Book("The Hobbit", "Fantasy", 310),
			    new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", 309),

			    new Book("Sapiens", "History", 498)
			);
		
		Map<String, IntSummaryStatistics> statsByGenre =
			    listOfBooks.stream()
			               .collect(Collectors.groupingBy(
			                   b -> b.genre,
			                   Collectors.summarizingInt(b -> b.numberOfPages)
			               ));
		
		statsByGenre.forEach((genre, stats) -> {
		    System.out.println("  Genre: " + genre);
		    System.out.println("  Count: " + stats.getCount());
		    System.out.println("  Min: " + stats.getMin());
		    System.out.println("  Max: " + stats.getMax());
		    System.out.println("  Average: " + stats.getAverage());
		    System.out.println("  Sum: " + stats.getSum());
		    
		    System.out.println("----------------------------");
		});
		
		
	}
}
