import java.util.*;

public class LexicalTwist {

    private static boolean areReverseIgnoreCase(String a, String b) {
        if (a.length() != b.length()) return false;

        int left = 0;
        int right = b.length() - 1;

        while (left < a.length()) {
            char c1 = normalize(a.charAt(left));
            char c2 = normalize(b.charAt(right));

            if (c1 != c2) return false;

            left++;
            right--;
        }
        return true;
    }

    private static char normalize(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private static String reverseAndTwist(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            char c = normalize(word.charAt(i));
            sb.append(isVowel(c) ? '@' : c);
        }
        return sb.toString();
    }

    private static String mergeAndExtract(String w1, String w2) {
        String combined = (w1.trim() + w2.trim()).toUpperCase();

        int vowels = 0, consonants = 0;

        for (char c : combined.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                if (isVowel(c)) vowels++;
                else consonants++;
            }
        }

        if (vowels == consonants) {
            return "Vowels and consonants are equal";
        }

        boolean pickVowels = vowels > consonants;
        StringBuilder result = new StringBuilder();

        for (char c : combined.toCharArray()) {
            if (c < 'A' || c > 'Z') continue;

            if (pickVowels && isVowel(c) || !pickVowels && !isVowel(c)) {
                if (result.indexOf(String.valueOf(c)) == -1) {
                    result.append(c);
                }
            }
            if (result.length() == 2) break;
        }
        return result.toString();
    }

    public static void processWords(String s1, String s2) {
        if (s1.contains(" ")) {
            System.out.println(s1 + " is an invalid word");
            return;
        }
        if (s2.contains(" ")) {
            System.out.println(s2 + " is an invalid word");
            return;
        }

        if (areReverseIgnoreCase(s1, s2)) {
            System.out.println(reverseAndTwist(s1));
        } else {
            System.out.println(mergeAndExtract(s1, s2));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string 1");
        String first = sc.nextLine();

        System.out.println("Enter string 2");
        String second = sc.nextLine();

        processWords(first, second);
    }
}
