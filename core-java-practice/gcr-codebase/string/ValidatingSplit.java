import java.util.*;

public class ValidatingSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strArr = str.split(" ");
        String[] strArrSecond = split(str);

        int ans = Arrays.compare(strArr, strArrSecond);

        if (ans == 0) {
            System.out.println("Both are identical");
        }

        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(strArrSecond));

        sc.close();
    }

    // User-defined split method
    public static String[] split(String str) {
        String[] arr = new String[noOfWords(str)];

        int k = 0;
        String s = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                s += str.charAt(i);
            } else {
                arr[k] = s;
                s = "";
                k++;
            }
        }

        // Add last word
        arr[k] = s;

        return arr;
    }

    // Method to count words
    public static int noOfWords(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ans++;
            }
        }
        return ans + 1;
    }
}
