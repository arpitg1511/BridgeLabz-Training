import java.util.*;

public class ValidatingTrim {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] points = trimPoints(text);

        String userTrimmed = makeSubstring(text, points[0], points[1]);
        String builtInTrimmed = text.trim();

        boolean result = compareStrings(userTrimmed, builtInTrimmed);

        System.out.println(userTrimmed);
        System.out.println(builtInTrimmed);
        System.out.println(result);
        sc.close();
    }

    // find start and end index without spaces
    public static int[] trimPoints(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // create substring using charAt
    public static String makeSubstring(String str, int start, int end) {
        String result = "";

        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }

        return result;
    }

    // compare two strings using charAt
    public static boolean compareStrings(String a, String b) {

        if (a.length() != b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }

        return true;
    }
}
