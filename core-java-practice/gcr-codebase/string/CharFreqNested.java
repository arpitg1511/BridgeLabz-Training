import java.util.*;

public class CharFreqNested {

    // Method to find frequency using nested loops
    public static String[] findFrequency(String str) {
        char[] chars = str.toCharArray();   // store characters
        int[] freq = new int[chars.length];

        // initialize frequency array
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
        }

        // nested loops to find frequency
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') continue;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // count unique characters
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') count++;
        }

        // store result in 1D String array
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] result = findFrequency(input);

        // display result
        for (String s : result) {
            System.out.println(s);
        }
        
        sc.close();
    }
}
