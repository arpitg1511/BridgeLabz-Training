import java.util.Scanner;

public class SubstringOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String mainStr = sc.nextLine();

        String subStr = sc.nextLine();

        int count = 0;
        int mainLength = mainStr.length();
        int subLength = subStr.length();

        // Loop through main string
        for (int i = 0; i <= mainLength - subLength; i++) {
            boolean match = true;

            // Check character by character
            for (int j = 0; j < subLength; j++) {
                if (mainStr.charAt(i + j) != subStr.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        System.out.println("The substring occurs " + count + " times.");
        sc.close();
    }
}
