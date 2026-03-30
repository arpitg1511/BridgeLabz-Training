import java.io.*;

public class ReadCSV {

    public static void main(String[] args) {
        String fileName = "students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            System.out.println("Student Details:");
            System.out.println("----------------------------");

            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                if (isFirstLine) { // skip header
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 4) continue;

                String id = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                System.out.println("ID    : " + id);
                System.out.println("Name  : " + name);
                System.out.println("Age   : " + age);
                System.out.println("Marks : " + marks);
                System.out.println("----------------------------");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file.");
        } catch (Exception e) {
            System.out.println("Invalid data format in CSV.");
        }
    }
}
