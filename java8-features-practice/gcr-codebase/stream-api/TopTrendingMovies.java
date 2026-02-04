import java.util.*;
import java.util.stream.Collectors;

/*
 * Movie class
 */
class Movie {
    String name;
    double rating;
    int releaseYear;

    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
}

public class TopTrendingMovies {

    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Movie A", 8.5, 2023));
        movies.add(new Movie("Movie B", 9.0, 2022));
        movies.add(new Movie("Movie C", 7.8, 2021));
        movies.add(new Movie("Movie D", 9.2, 2023));
        movies.add(new Movie("Movie E", 8.9, 2022));
        movies.add(new Movie("Movie F", 9.1, 2023));
        movies.add(new Movie("Movie G", 7.5, 2020));

        // Top 5 trending movies based on rating and release year
        List<Movie> topMovies = movies.stream()
                .sorted((m1, m2) -> {                        // sort by rating then year
                    if (m1.rating == m2.rating) {
                        return m2.releaseYear - m1.releaseYear;
                    }
                    return Double.compare(m2.rating, m1.rating);
                })
                .limit(5)                                   // top 5 only
                .collect(Collectors.toList());

        // Display result
        for (Movie m : topMovies) {
            System.out.println(
                    m.name + " | Rating: " + m.rating + " | Year: " + m.releaseYear
            );
        }
    }
}
