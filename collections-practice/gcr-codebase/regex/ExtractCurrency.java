import java.util.regex.*;
import java.util.*;

public class ExtractCurrency {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        
        // Regex pattern to match currency values (with or without $)
        String regex = "\\$?\\d+(\\.\\d+)?";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        List<String> values = new ArrayList<>();
        
        while (matcher.find()) {
            values.add(matcher.group());
        }
        
        System.out.println(String.join(", ", values));
    }
}
