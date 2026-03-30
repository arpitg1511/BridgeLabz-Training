import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {

    private static final String LINK_REGEX = "https?://[^\\s]+";

    public static void main(String[] args) {
        String text =
            "Visit https://www.google.com and http://example.org for more info.";

        Pattern pattern = Pattern.compile(LINK_REGEX);
        Matcher matcher = pattern.matcher(text);

        boolean first = true;
        while (matcher.find()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(matcher.group());
            first = false;
        }
    }
}
