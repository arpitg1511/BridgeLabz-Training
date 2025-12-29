import java.util.*;

public class PalindromeCheck {

    public static void main(String[] args) {

        // Take input string from user
        String str = input();

        // Check whether the string is palindrome
        boolean palindrome = isPalindrome(str);

        // Display the result
        display(palindrome);
    }

    // Method to read input string
    public static String input() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        return str;
    }

    // Method to check palindrome by comparing characters from both ends
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            // If mismatch found, string is not a palindrome
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true; // All characters matched
    }

    // Method to display result
    public static void display(boolean b) {
        if (b) {
            System.out.println("Given string is a Palindrome");
            return;
        }
        System.out.println("Given string is not a Palindrome");
    }
}
