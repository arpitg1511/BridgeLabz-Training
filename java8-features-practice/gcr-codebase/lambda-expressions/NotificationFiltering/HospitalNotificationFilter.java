package NotificationFiltering;

import java.util.*;
import java.util.function.Predicate;

public class HospitalNotificationFilter {

    public static void main(String[] args) {

        List<Alert> alerts = List.of(
            new Alert("Heart rate critical", "EMERGENCY"),
            new Alert("Take blood pressure medicine", "MEDICATION"),
            new Alert("Doctor appointment tomorrow", "APPOINTMENT"),
            new Alert("Hospital newsletter", "GENERAL")
        );

        // User preference
        Set<String> preferredAlerts = Set.of("EMERGENCY", "MEDICATION");

        // Predicate using lambda
        Predicate<Alert> alertFilter =
                alert -> preferredAlerts.contains(alert.type);

        // Apply filter
        alerts.stream()
              .filter(alertFilter)
              .forEach(System.out::println);
    }
}

