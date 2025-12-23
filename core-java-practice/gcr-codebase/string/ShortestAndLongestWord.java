import java.util.*;

public class ShortestAndLongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] wordLen = wordWithLength(words);
        int[] result = shortestLongest(wordLen);

        System.out.println("Shortest word: " + wordLen[result[0]][0]);
        System.out.println("Longest word: " + wordLen[result[1]][0]);
    }

    // split text into words using charAt
    public static String[] splitWords(String str) {
        int count = 1;
        for (int i = 0; i < length(str); i++) {
            if (str.charAt(i) == ' ')
                count++;
        }

        String[] arr = new String[count];
        String temp = "";
        int k = 0;

        for (int i = 0; i < length(str); i++) {
            if (str.charAt(i) != ' ') {
                temp += str.charAt(i);
            } else {
                arr[k++] = temp;
                temp = "";
            }
        }
        arr[k] = temp;
        return arr;
    }

    // find length without using length()
    public static int length(String str) {
        int len = 0;
        for (char c : str.toCharArray())
            len++;
        return len;
    }

    // create 2D array of word and length
    public static String[][] wordWithLength(String[] words) {
        String[][] arr = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            arr[i][0] = words[i];
            arr[i][1] = String.valueOf(length(words[i]));
        }
        return arr;
    }

    // find shortest and longest
    public static int[] shortestLongest(String[][] arr) {
        int min = 0, max = 0;

        for (int i = 1; i < arr.length; i++) {
            if (Integer.parseInt(arr[i][1]) < Integer.parseInt(arr[min][1]))
                min = i;
            if (Integer.parseInt(arr[i][1]) > Integer.parseInt(arr[max][1]))
                max = i;
        }
        return new int[]{min, max};
    }
}
