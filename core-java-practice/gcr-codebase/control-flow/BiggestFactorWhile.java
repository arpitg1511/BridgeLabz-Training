import java.util.*;

public class BiggestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt(); // user input

        // Find the biggest factor other than the number itself
        int i = num - 1;
        while(i >= 1) {
            if (num % i == 0) {
                System.out.println(i);
                break;
            }
            i--;
        }

        sc.close();
    }
}
