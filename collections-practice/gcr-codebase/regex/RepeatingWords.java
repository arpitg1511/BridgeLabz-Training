import java.util.regex.*;
import java.util.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";
        
        // Regex pattern to find repeated words
        String regex = "\\b(\\w+)\\s+\\1\\b";
        
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);
        
        Set<String> repeatedWords = new LinkedHashSet<>(); // To avoid duplicates and maintain order
        
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }
        
        System.out.println(String.join(", ", repeatedWords));
    }
}
