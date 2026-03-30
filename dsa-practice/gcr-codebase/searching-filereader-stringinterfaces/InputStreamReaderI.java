import java.io.*;
import java.nio.charset.StandardCharsets;

class InputStreamReaderI {

    public static void main(String[] args) {

        // Path of the file to be read
        String filePath = "C:\\Users\\disco\\OneDrive\\Desktop\\data.txt";

        // Try-with-resources ensures proper closing of streams
        try (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr)
        ) {

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Handles FileNotFoundException + UnsupportedEncodingException + IO errors
            e.printStackTrace();
        }
    }
}
