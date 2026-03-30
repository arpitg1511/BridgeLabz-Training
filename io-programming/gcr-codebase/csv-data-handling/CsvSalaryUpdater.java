import java.io.*;

public class CsvSalaryUpdater {

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            String line;
            boolean isHeader = true;

            int deptIndex = -1;
            int salaryIndex = -1;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    // find column indexes
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].equalsIgnoreCase("Department")) deptIndex = i;
                        if (data[i].equalsIgnoreCase("Salary")) salaryIndex = i;
                    }
                    writer.append(line).append("\n"); // write header
                    isHeader = false;
                    continue;
                }

                // Update salary for IT department
                if (data[deptIndex].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[salaryIndex]);
                    salary = salary * 1.10; // increase by 10%
                    data[salaryIndex] = String.valueOf((int) salary);
                }

                writer.append(String.join(",", data)).append("\n");
            }

            System.out.println("Salary update completed. File saved as " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
