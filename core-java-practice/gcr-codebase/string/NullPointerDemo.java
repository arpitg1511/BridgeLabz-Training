import java.util.*;

public class NullPointerDemo {

    public static void main(String[] args) {

        // Generate exception
        try {
            generateException();
        } catch (NullPointerException e) {
            // Call method to handle exception
            handleException();
        }
    }

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
        }
    }
}
