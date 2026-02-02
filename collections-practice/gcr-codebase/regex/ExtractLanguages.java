import java.util.regex.*;
import java.util.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        
        // List of programming languages we want to extract
        String[] languages = {"Java", "Python", "JavaScript", "Go"};
        
        List<String> found = new ArrayList<>();
        
        for (String lang : languages) {
            // Regex pattern with word boundaries to match whole words
            Pattern pattern = Pattern.compile("\\b" + lang + "\\b");
            Matcher matcher = pattern.matcher(text);
            
            if (matcher.find()) {
                found.add(lang);
            }
        }
        
        // Print the result
        System.out.println(String.join(", ", found));
    }
}
