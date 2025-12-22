import java.util.*;

public class IllegalArgumentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        try {
            generateException(str);
        } catch (IllegalArgumentException e) {
            handleException();
        }

        sc.close();
    }

    // Method to generate exception
    public static void generateException(String str) {
        int start = 6;
        int end = 2;

        if (start > end) {
            throw new IllegalArgumentException();
        }

        System.out.println(str.substring(start, end));
    }


    // Method to handle exception
    public static void handleException() {
        System.out.println("IllegalArgumentException Handled");
    }
}
