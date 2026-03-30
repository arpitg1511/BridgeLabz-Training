import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public static void main(String[] args) {
        String[] headers = {"ID", "Name", "Department", "Salary"};
        String[][] employees = {
                {"101", "Arpit", "IT", "50000"},
                {"102", "Riya", "HR", "45000"},
                {"103", "Aman", "Finance", "55000"},
                {"104", "Neha", "Marketing", "48000"},
                {"105", "Rahul", "IT", "52000"}
        };

        try (FileWriter writer = new FileWriter("students.csv")) {
            // Write headers
            writer.append(String.join(",", headers)).append("\n");

            // Write records
            for (String[] emp : employees) {
                writer.append(String.join(",", emp)).append("\n");
            }

            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
