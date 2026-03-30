import java.util.*;
public class LargestNumberOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int thirdNumber = sc.nextInt();

        int ans = Math.max(firstNumber, Math.max(secondNumber, thirdNumber));
        System.out.println("Is the first number the largest? " + (ans == firstNumber ? "Yes" : "No"));

        System.out.println("Is the second number the largest? " + (ans == secondNumber ? "Yes" : "No"));

        System.out.println("Is the third number the largest? " + (ans == thirdNumber ? "Yes" : "No"));

        sc.close();
    }   
}
