import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvSearch {

    public static void main(String[] args) {
        String filePath = "employees.csv"; // CSV file path
        String searchName = "Neha";        // Name to search

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int nameIndex = -1;
            int deptIndex = -1;
            int salaryIndex = -1;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");

                if (isHeader) {
                    // Identify column indexes
                    for (int i = 0; i < tokens.length; i++) {
                        if (tokens[i].equalsIgnoreCase("Name")) nameIndex = i;
                        if (tokens[i].equalsIgnoreCase("Department")) deptIndex = i;
                        if (tokens[i].equalsIgnoreCase("Salary")) salaryIndex = i;
                    }
                    isHeader = false;
                    continue;
                }

                if (tokens[nameIndex].equalsIgnoreCase(searchName)) {
                    System.out.println("Employee: " + tokens[nameIndex]);
                    System.out.println("Department: " + tokens[deptIndex]);
                    System.out.println("Salary: " + tokens[salaryIndex]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
