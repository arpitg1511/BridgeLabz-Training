import java.io.*;

public class CsvFilter {

    public static void main(String[] args) {
        String filePath = "students.csv"; // CSV file with Marks column

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    System.out.println(line); // print header
                    isHeader = false;
                    continue;
                }

                String[] tokens = line.split(","); // assuming comma-separated
                // Assuming Marks is the 5th column (index 4)
                int marks = Integer.parseInt(tokens[4]);

                if (marks > 80) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
