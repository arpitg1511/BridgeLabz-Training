import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String ssn1 = "123-45-6789";  // Valid
        String ssn2 = "123456789";    // Invalid
        
        System.out.println(ssn1 + " is valid? " + isValidSSN(ssn1));
        System.out.println(ssn2 + " is valid? " + isValidSSN(ssn2));
    }
    
    public static boolean isValidSSN(String ssn) {
        // Regex pattern for SSN: 3 digits - 2 digits - 4 digits
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        
        return Pattern.matches(regex, ssn);
    }
}
