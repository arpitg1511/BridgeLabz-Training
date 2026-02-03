import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LargeCsvReader {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "students.csv";
        long totalRecords = 0;

        List<String> buffer = new ArrayList<>(CHUNK_SIZE);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header if present
            line = br.readLine(); // comment this if no header

            while ((line = br.readLine()) != null) {

                buffer.add(line);

                if (buffer.size() == CHUNK_SIZE) {
                    processChunk(buffer);
                    totalRecords += buffer.size();
                    buffer.clear();

                    System.out.println("Records processed so far: " + totalRecords);
                }
            }

            // Process remaining lines (< 100)
            if (!buffer.isEmpty()) {
                processChunk(buffer);
                totalRecords += buffer.size();
                buffer.clear();
            }

            System.out.println("✅ Total records processed: " + totalRecords);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processChunk(List<String> chunk) {
        // 🔹 Business logic here
        // Example: parse CSV, save to DB, validate data, etc.

        for (String record : chunk) {
            // simulate processing
             System.out.println(record);
        }
    }
}
