import java.io.*;
import java.util.regex.*;

public class CsvValidator {

    // Simple email regex (interview-safe)
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\d{10}$");

    public static void main(String[] args) {
        String filePath = "users.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            int emailIndex = -1;
            int phoneIndex = -1;
            int rowNumber = 0;

            while ((line = br.readLine()) != null) {
                rowNumber++;
                String[] data = line.split(",");

                if (isHeader) {
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].equalsIgnoreCase("Email")) emailIndex = i;
                        if (data[i].equalsIgnoreCase("Phone")) phoneIndex = i;
                    }
                    isHeader = false;
                    continue;
                }

                String email = data[emailIndex];
                String phone = data[phoneIndex];

                boolean valid = true;

                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.println("Invalid Email at row " + rowNumber + ": " + line);
                    valid = false;
                }

                if (!PHONE_PATTERN.matcher(phone).matches()) {
                    System.out.println("Invalid Phone at row " + rowNumber + ": " + line);
                    valid = false;
                }

                if (!valid) {
                    System.out.println("→ Error: Validation failed\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
