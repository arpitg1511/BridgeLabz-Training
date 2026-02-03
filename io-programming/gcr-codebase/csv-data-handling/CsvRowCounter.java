import java.io.*;

public class CsvRowCounter {

    public static void main(String[] args) {
        String filePath = "students.csv"; // path to your CSV
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // skip header
                    continue;
                }
                rowCount++;
            }

            System.out.println("Number of records (excluding header): " + rowCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
