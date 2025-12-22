import java.util.*;

public class CompareUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String builtIn = str.toUpperCase();
        String userMade = upper(str);

        // Compare both strings
        if (builtIn.equals(userMade)) {
            System.out.println("Both are equal");
        }

        System.out.println(builtIn);
        System.out.println(userMade);

        sc.close();
    }

    // Convert string to uppercase without built-in method
    public static String upper(String str) {
        String dummy = "";
        for (int i = 0; i < str.length(); i++) {
        	if(str.charAt(i) >= 97 && str.charAt(i) <= 122)
            dummy += (char)(str.charAt(i) - 32);
        	
        	else
        		dummy += str.charAt(i);
        }
        return dummy;
    }
}
