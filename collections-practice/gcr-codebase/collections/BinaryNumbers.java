import java.util.*;

public class BinaryNumbers {

    static void generateBinary(int n) {

        Queue<String> queue = new LinkedList<>();

        // First binary number
        queue.add("1");

        for (int i = 1; i <= n; i++) {

            String current = queue.remove();
            System.out.print(current + " ");

            // Generate next binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    public static void main(String[] args) {

        int N = 5;

        System.out.println("First " + N + " binary numbers:");
        generateBinary(N);
    }
}
