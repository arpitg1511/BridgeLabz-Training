import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {

    // dd/mm/yyyy (basic validation: day 01–31, month 01–12)
    private static final String DATE_REGEX =
            "\\b(0[1-9]|[12][0-9]|3[01])/"
          + "(0[1-9]|1[0-2])/"
          + "\\d{4}\\b";

    public static void main(String[] args) {
        String text =
            "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        Pattern pattern = Pattern.compile(DATE_REGEX);
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
