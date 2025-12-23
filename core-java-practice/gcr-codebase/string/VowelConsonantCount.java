import java.util.*;

public class VowelConsonantCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] result = countVowelsConsonants(text);

        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }

    // check vowel / consonant / not letter
    public static int checkChar(char ch) {

        // convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        // check letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return 1; // vowel
            else
                return 2; // consonant
        }

        return 0; // not a letter
    }

    // count vowels and consonants
    public static int[] countVowelsConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            int res = checkChar(str.charAt(i));

            if (res == 1)
                vowels++;
            else if (res == 2)
                consonants++;
        }

        return new int[]{vowels, consonants};
    }
}
