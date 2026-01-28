import java.util.*;

public class MultipleCatch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer[] arr = {10, 20, 30, 40, 50};
        // Integer[] arr = null;   // uncomment to test NullPointerException

        try {
            System.out.print("Enter index: ");
            int index = sc.nextInt();

            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index is out of array range");

        } catch (NullPointerException e) {
            System.out.println("Array is null");

        }
        
        sc.close();
    }
}
