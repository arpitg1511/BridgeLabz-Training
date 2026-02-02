import java.util.regex.*;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String card1 = "4123456789012345"; // Visa
        String card2 = "5123456789012345"; // MasterCard
        String card3 = "6123456789012345"; // Invalid
        
        System.out.println(card1 + " is valid? " + isValidCard(card1));
        System.out.println(card2 + " is valid? " + isValidCard(card2));
        System.out.println(card3 + " is valid? " + isValidCard(card3));
    }
    
    public static boolean isValidCard(String cardNumber) {
        // Regex pattern for Visa (4) or MasterCard (5) with 16 digits
        String regex = "^(4\\d{15}|5\\d{15})$";
        
        return Pattern.matches(regex, cardNumber);
    }
}

