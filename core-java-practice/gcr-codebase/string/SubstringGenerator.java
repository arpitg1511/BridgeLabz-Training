import java.util.*;

public class SubstringGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String originalString = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        // Validate indices
        if (start > end || end >= originalString.length()) {
            System.out.println("Invalid start or end index");
            sc.close();
            return;
        }

        // Create substring using charAt()
        String firstSubstr = "";
        for (int i = start; i <= end; i++) {
            firstSubstr += originalString.charAt(i);
        }

        // Create substring using built-in method
        String secondSubstr = originalString.substring(start, end + 1);

        System.out.println(firstSubstr);
        System.out.println(secondSubstr);

        // Compare both substrings
        if (firstSubstr.equals(secondSubstr)) {
            System.out.println("Both are equal");
        }

        sc.close();
    }
}
