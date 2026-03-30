import java.util.*;

public class IndexBoundDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        try {
            generateException(str);
        } catch (StringIndexOutOfBoundsException e) {
            handleException();
        }

        sc.close();
    }

    // Method to generate exception
    public static void generateException(String str) {
        System.out.println(str.charAt(str.length()));
    }

    // Method to handle exception
    public static void handleException() {
        System.out.println("StringIndexOutOfBoundsException Handled");
    }
}
