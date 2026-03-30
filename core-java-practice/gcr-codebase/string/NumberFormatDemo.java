import java.util.*;

public class NumberFormatDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();

        // Call method to generate exception
        try {
            generateException(text);
        } catch (NumberFormatException e) {
            // After exception, call handling method
            handleException(text);
        }

        sc.close();
    }

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {
        
            System.out.println("NumberFormatException Handled");
       
    }
}
