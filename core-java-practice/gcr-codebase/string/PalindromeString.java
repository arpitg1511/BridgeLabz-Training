import java.util.*;

public class PalindromeString {

    // Logic 1: Using start and end index comparison
    public static boolean isPalindromeLogic1(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive palindrome check
    public static boolean isPalindromeLogic2(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeLogic2(str, start + 1, end - 1);
    }

    // Method to reverse string using charAt()
    public static char[] reverseString(String str) {
        int len = str.length();
        char[] rev = new char[len];
        int index = 0;

        for (int i = len - 1; i >= 0; i--) {
            rev[index] = str.charAt(i);
            index++;
        }
        return rev;
    }

    // Logic 3: Using character arrays
    public static boolean isPalindromeLogic3(String str) {
        char[] original = str.toCharArray();
        char[] reverse = reverseString(str);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(isPalindromeLogic1(input));
        System.out.println(isPalindromeLogic2(input, 0, input.length() - 1));
        System.out.println(isPalindromeLogic3(input));
        sc.close();
    }
}
