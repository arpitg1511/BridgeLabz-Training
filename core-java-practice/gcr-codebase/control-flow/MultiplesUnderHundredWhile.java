import java.util.Scanner;

public class MultiplesUnderHundredWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt(); // user input

        // Proceed only if number is positive and less than 100
        if (number > 0 && number < 100) {
        	int i = 100;
            while(i >= 1) {
                if (i % number == 0) {
                    System.out.println(i);
                }
                
                i--;
            }
        }

        sc.close();
    }
}
