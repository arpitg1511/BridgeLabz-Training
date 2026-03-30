import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Arpit Gupta")
class Book {
}

public class RetrieveAnnotations{

    public static void main(String[] args) {

        Class<Book> cls = Book.class;

        if (cls.isAnnotationPresent(Author.class)) {

            Author author = cls.getAnnotation(Author.class);

            System.out.println("Author Name: " + author.name());
        }
    }
}

