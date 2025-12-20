import java.util.*;

public class BiggestFactorFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt(); // user input

        // Find the biggest factor other than the number itself
        for (int i = num - 1; i >= 1; i--) {
            if (num % i == 0) {
                System.out.println(i);
                break;
            }
        }

        sc.close();
    }
}
