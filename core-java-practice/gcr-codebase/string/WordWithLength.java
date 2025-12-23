import java.util.*;

public class WordWithLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] result = wordWithLength(words);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + Integer.parseInt(result[i][1]));
        }
        
        sc.close();
    }

    // Split text into words using charAt()
    public static String[] splitWords(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }

        String[] words = new String[count];
        String temp = "";
        int k = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                temp += text.charAt(i);
            } else {
                words[k++] = temp;
                temp = "";
            }
        }
        words[k] = temp;

        return words;
    }

    // Find length of string without using length()
    public static int stringLength(String word) {
        int len = 0;
        for (char c : word.toCharArray()) {
            len++;
        }
        return len;
    }

    // Create 2D array of word and its length
    public static String[][] wordWithLength(String[] words) {
        String[][] arr = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            arr[i][0] = words[i];
            arr[i][1] = String.valueOf(stringLength(words[i]));
        }

        return arr;
    }
}
