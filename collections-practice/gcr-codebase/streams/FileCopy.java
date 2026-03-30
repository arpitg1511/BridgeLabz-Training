import java.io.*;

public class FileCopy {

    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Source file (change the name if needed)
            fis = new FileInputStream("C:\\Users\\disco\\OneDrive\\Desktop\\data.txt");

            // Destination file (will be created automatically if not present)
            fos = new FileOutputStream("destination.txt");

            int data;

            // Read byte by byte and write to destination file
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            // Handles file not found and other IO errors
            System.out.println("Source file does not exist or an error occurred.");
        } finally {
            // Closing resources
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the file.");
            }
        }
    }
}
