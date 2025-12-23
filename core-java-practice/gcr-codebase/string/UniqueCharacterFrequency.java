import java.util.*;

public class UniqueCharacterFrequency {

    // Method to find unique characters using nested loops
    public static char[] uniqueCharacters(String str) {
        int len = str.length();
        char[] temp = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[index] = ch;
                index++;
            }
        }

        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    // Method to find frequency using unique characters
    public static String[][] findFrequency(String str) {
        int[] freq = new int[256];

        // count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        char[] uniqueChars = uniqueCharacters(str);
        String[][] result = new String[uniqueChars.length][2];

        // store unique characters and their frequencies
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = Character.toString(uniqueChars[i]);
            result[i][1] = Integer.toString(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[][] freqResult = findFrequency(input);

        // display result
        for (int i = 0; i < freqResult.length; i++) {
            System.out.println(freqResult[i][0] + " " + freqResult[i][1]);
        }
        sc.close();
    }
}
