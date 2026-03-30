import java.util.*;

public class FlipKey {

    private static boolean isValidWord(String text) {
        if (text == null || text.length() < 6) {
            return false;
        }

        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private static String buildKey(String word) {
        String lower = word.toLowerCase();
        StringBuilder temp = new StringBuilder();

        // keep only chars with odd ASCII value
        for (char c : lower.toCharArray()) {
            if (c % 2 != 0) {
                temp.append(c);
            }
        }

        temp.reverse();

        // convert characters at even index to uppercase
        for (int i = 0; i < temp.length(); i += 2) {
            char c = temp.charAt(i);
            temp.setCharAt(i, Character.toUpperCase(c));
        }

        return temp.toString();
    }

    public static String generateKey(String input) {
        if (!isValidWord(input)) {
            return "";
        }
        return buildKey(input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word");
        String data = sc.nextLine();

        String result = generateKey(data);

        if (!result.isEmpty()) {
            System.out.println("The generated key is - " + result);
        } else {
            System.out.println("Invalid Input");
        }
    }
}
