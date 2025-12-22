import java.util.*;

public class CompareString {
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next(); // first string
        String str2 = sc.next(); // second string

        boolean resultUsingCharAt = compareUsingCharAt(str1, str2);
        boolean resultUsingEquals = str1.equals(str2);

        System.out.println(resultUsingCharAt);
        System.out.println(resultUsingEquals);

        sc.close();
    }
}
