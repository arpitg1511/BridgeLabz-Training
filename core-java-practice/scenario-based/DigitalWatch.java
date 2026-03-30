public class DigitalWatch {

    public static void main(String[] args) {

        // Outer loop for hours (0 to 23)
        for (int hour = 0; hour < 24; hour++) {

            // Inner loop for minutes (0 to 59)
            for (int minute = 0; minute < 60; minute++) {

                // Stop the watch at 13:00 (power cut)
                if (hour == 13 && minute == 0) {
                    System.out.println("Power cut! Watch stopped at 13:00");
                    break;
                }

                // Print time in HH:MM format
                System.out.printf("%02d:%02d\n", hour, minute);
            }

            // Break outer loop as well when power cut happens
            if (hour == 13) {
                break;
            }
        }
    }
}
