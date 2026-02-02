import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordExtractor {

    private static final String CAPITAL_WORD_REGEX = "\\b[A-Z][a-z]*\\b";

    public static void main(String[] args) {
        String text =
            "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        Pattern pattern = Pattern.compile(CAPITAL_WORD_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

