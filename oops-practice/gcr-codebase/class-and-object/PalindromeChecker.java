import java.util.*;

public class PalindromeChecker {

    // Instance variable to store the input text
    String text;

    // Constructor to initialize the text
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to display whether the text is palindrome or not
    void display() {

        // Call checkPalindrome() and print result based on return value
        if (checkPalindrome())
            System.out.printf("%s is a palindrome", text);
        else
            System.out.printf("%s is not a palindrome", text);
    }

    // Method to check if the given text is a palindrome
    boolean checkPalindrome() {

        // Pointer starting from beginning of string
        int low = 0;

        // Pointer starting from end of string
        int high = text.length() - 1;

        // Convert string to lowercase for case-insensitive comparison
        String t = text.toLowerCase();

        // Loop until both pointers meet
        while (low < high) {

            // Skip spaces from the left side
            while (low < high && t.charAt(low) == ' ')
                low++;

            // Skip spaces from the right side
            while (low < high && t.charAt(high) == ' ')
                high--;

            // Compare characters from both ends
            if (t.charAt(low) != t.charAt(high))
                return false; // Not a palindrome

            // Move pointers inward
            low++;
            high--;
        }

        // If all characters match, it is a palindrome
        return true;
    }

    // Main method: execution starts here
    public static void main(String[] args) {

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Read the input string
        String text = sc.nextLine();

        // Create PalindromeChecker object
        PalindromeChecker pc = new PalindromeChecker(text);

        // Display result
        pc.display();

        // Close scanner to avoid resource leak
        sc.close();
    }
}
