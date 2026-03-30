import java.util.*;

public class CharacterFrequency {

    // Method to find frequency of characters and return as 2D array
    public static String[][] findCharFrequency(String str) {
        int[] freq = new int[256]; // frequency array for all ASCII characters
        int len = str.length();

        // count frequency of each character
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        // count number of unique characters to size the result array
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // store character and its frequency in result array
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = Character.toString((char)i);
                result[index][1] = Integer.toString(freq[i]);
                index++;
            }
        }

        return result;
    }

    // Method to display 2D array
    public static void displayFrequency(String[][] freqArray) {
        System.out.println("Character\tFrequency");
        for (String[] arr : freqArray) {
            System.out.println(arr[0] + "\t\t" + arr[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // take input string

        String[][] freqArray = findCharFrequency(input); // get frequency array
        displayFrequency(freqArray); // display in tabular format
        sc.close();
    }
}
