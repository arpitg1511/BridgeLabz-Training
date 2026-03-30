import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String ip1 = "192.168.1.1";
        String ip2 = "256.100.50.0"; // Invalid
        
        System.out.println(ip1 + " is valid? " + isValidIP(ip1));
        System.out.println(ip2 + " is valid? " + isValidIP(ip2));
    }
    
    public static boolean isValidIP(String ip) {
        // Regex pattern for IPv4 address
        String zeroTo255 = "([0-9]{1,2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
        String regex = "^" + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "$";
        
        // Check using Pattern.matches
        return Pattern.matches(regex, ip);
    }
}
