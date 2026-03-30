import java.util.*;

public class ReplaceWord {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        int n = sentence.length();
        int m = oldWord.length();

        while (i < n) {
            boolean match = true;

            // Check if oldWord matches at position i
            if (i + m <= n) {
                for (int j = 0; j < m; j++) {
                    if (sentence.charAt(i + j) != oldWord.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            } else {
                match = false;
            }

            // Ensure whole-word match
            if (match &&
               (i == 0 || sentence.charAt(i - 1) == ' ') &&
               (i + m == n || sentence.charAt(i + m) == ' ')) {

                result.append(newWord);
                i += m;
            } else {
                result.append(sentence.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        String oldWord = sc.next();

        String newWord = sc.next();

        System.out.println(replaceWord(sentence, oldWord, newWord));

        sc.close();
    }
}
