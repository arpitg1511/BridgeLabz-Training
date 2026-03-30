import java.util.*;

public class FactorsOfNumberWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // user input

        // Loop to find factors excluding 1 and the number itself
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                System.out.println(i);
            }
            i++;
        }

        sc.close();
    }
}
