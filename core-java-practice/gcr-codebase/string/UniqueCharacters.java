import java.util.*;

public class UniqueCharacters {

    // Method to find the length of a string without using length()
    public static int getLength(String str) {
        int count = 0;
        char[] chars = str.toCharArray(); // convert string to char array
        for (char ch : chars) {
            count++;
        }
        return count;
    }

    // Method to find unique characters in a string
    public static char[] findUniqueChars(String str) {
        int len = getLength(str);
        char[] temp = new char[len]; // temporary array to store unique characters
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            boolean isUnique = true;

            // check if character appeared before
            for (int j = 0; j < index; j++) {
                if (temp[j] == ch) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[index] = ch;
                index++;
            }
        }

        // create array of exact size to store unique characters
        char[] uniqueChars = new char[index];
        for (int i = 0; i < index; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // take input string

        char[] uniqueChars = findUniqueChars(input);

        // display unique characters
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }
        
        sc.close();
    }
}
