import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {

    private static final String EMAIL_REGEX =
            "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+";

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

