import java.util.Scanner;

public class CompareLowerCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String builtIn = str.toLowerCase();
        String userMade = lower(str);

        // Compare both strings
        if (builtIn.equals(userMade)) {
            System.out.println("Both are equal");
        }

        System.out.println(builtIn);
        System.out.println(userMade);

        sc.close();
    }

    // Convert string to lowercase without built-in method
    public static String lower(String str) {
        String dummy = "";
        for (int i = 0; i < str.length(); i++) {
        	if(str.charAt(i) >= 65 && str.charAt(i) <= 90)
            dummy += (char)(str.charAt(i) + 32);
        	
        	else
        		dummy += str.charAt(i);
        }
        return dummy;
    }
}
