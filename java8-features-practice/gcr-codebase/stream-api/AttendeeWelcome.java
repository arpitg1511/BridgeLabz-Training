import java.util.Arrays;
import java.util.List;

public class AttendeeWelcome {

    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
                "Arpit",
                "Rohit",
                "Neha",
                "Priya"
        );

        attendees.forEach(name ->
                System.out.println("Welcome to the event, " + name + "!")
        );
    }
}
