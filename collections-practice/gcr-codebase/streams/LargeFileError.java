import java.io.*;

public class LargeFileError {

    public static void main(String[] args) {
        String filename = "largefile.txt"; // replace with your large file path

        BufferedReader br = null;

        try {
            // Use BufferedReader for efficient line-by-line reading
            br = new BufferedReader(new FileReader(filename));

            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                // Check if line contains "error" (case-insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                    count++;
                }
            }

            System.out.println("\nTotal lines containing 'error': " + count);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing BufferedReader: " + e.getMessage());
            }
        }
    }
}
