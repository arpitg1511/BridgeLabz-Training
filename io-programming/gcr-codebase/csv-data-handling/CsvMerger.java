import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CsvMerger {

    static class StudentBasic {
        String name;
        int age;

        StudentBasic(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        String file1 = "students.csv"; // ID,Name,Age
        String file2 = "employees.csv"; // ID,Marks,Grade
        String outputFile = "students_merged.csv";

        Map<Integer, StudentBasic> studentMap = new HashMap<>();

        // 🔹 Read students1.csv
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.replace("\uFEFF", "").trim();

                if (line.toLowerCase().startsWith("id")) continue;

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());

                studentMap.put(id, new StudentBasic(name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 🔹 Read students2.csv and merge
        try (
                BufferedReader br = new BufferedReader(new FileReader(file2));
                FileWriter writer = new FileWriter(outputFile)
        ) {
            writer.write("ID,Name,Age,Marks,Grade\n");

            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("\uFEFF", "").trim();

                if (line.toLowerCase().startsWith("id")) continue;

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0].trim());
                int marks = Integer.parseInt(data[1].trim());
                String grade = data[2].trim();

                if (studentMap.containsKey(id)) {
                    StudentBasic sb = studentMap.get(id);

                    writer.write(
                            id + "," +
                            sb.name + "," +
                            sb.age + "," +
                            marks + "," +
                            grade + "\n"
                    );
                }
            }

            System.out.println("CSV files merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
