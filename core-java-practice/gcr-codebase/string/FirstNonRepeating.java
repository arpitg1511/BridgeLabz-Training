import java.util.*;

public class FirstNonRepeating {

    // Method to find the first non-repeating character in a string
    public static char firstNonRepeating(String str) {
        int[] freq = new int[256]; // array to store frequency of ASCII characters

        int len = str.length(); // string length

        // loop to count frequency of each character
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        // loop to find the first character with frequency 1
        for (int i = 0; i < len; i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return '\0'; // return null character if no non-repeating character exists
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // take input string

        char result = firstNonRepeating(input);

        // display the result
        if (result != '\0') {
            System.out.println(result);
        }
        sc.close();
    }
}
