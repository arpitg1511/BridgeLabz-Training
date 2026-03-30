import java.util.*;

public class ArrayIndexDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        // First call method to generate exception
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Then call method to handle exception
            handleException(names);
        }

        sc.close();
    }

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {
            System.out.println("ArrayIndexOutOfBoundsException Handled");
    }
}
