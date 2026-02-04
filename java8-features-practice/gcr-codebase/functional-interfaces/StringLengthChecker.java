import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        int limit = 20;

        // Function to calculate length of string
        Function<String, Integer> getLength =
                msg -> msg.length();

        String message = "Please submit your assignment today";

        int length = getLength.apply(message);

        if (length > limit) {
            System.out.println("Message exceeds character limit");
        } else {
            System.out.println("Message is within character limit");
        }
    }
}
