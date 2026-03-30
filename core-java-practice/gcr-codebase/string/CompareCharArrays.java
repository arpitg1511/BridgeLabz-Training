import java.util.*;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String originalString = sc.next();

        // Convert string to char array using built-in method
        char[] charArr = originalString.toCharArray();

        // Convert string to char array using charAt()
        char[] charArrSecond = characterArray(originalString);

        // Compare both character arrays
        int ans = Arrays.compare(charArr, charArrSecond);
        if (ans == 0) {
            System.out.println("Both arrays are equal");
        }

        // Display characters
        for (int i = 0; i < charArr.length; i++) {
            System.out.println(charArr[i]);
        }

        sc.close();
    }

    // Method to create char array using charAt()
    public static char[] characterArray(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }
}
