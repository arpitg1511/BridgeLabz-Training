import java.io.*;
import java.util.*;

public class DetectDuplicateCsv {

    public static void main(String[] args) {

        String filePath = "employees.csv";
        Set<String> seenIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            br.readLine();

            System.out.println("🔍 Duplicate Records:");

            while ((line = br.readLine()) != null) {

                String[] columns = line.split(",");

                String id = columns[0].trim();

                // If ID already exists → duplicate
                if (!seenIds.add(id)) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
