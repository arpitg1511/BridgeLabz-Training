import java.util.*;

public class AlphabetTypeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[][] result = findCharType(text);

        display(result);
    }

    // Method to check character type
    public static String checkChar(char ch) {

        // convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return "Vowel";
            else
                return "Consonant";
        }

        return "Not a Letter";
    }

    // Method to create 2D array of character and its type
    public static String[][] findCharType(String str) {

        String[][] arr = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            arr[i][0] = String.valueOf(str.charAt(i));
            arr[i][1] = checkChar(str.charAt(i));
        }

        return arr;
    }

    // Method to display result in tabular format
    public static void display(String[][] arr) {
        System.out.println("Character\tType");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
        }
    }
}
