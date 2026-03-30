import java.io.*;

public class UpperToLowerFile {

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\disco\\OneDrive\\Desktop\\data.txt";    // original file
        String outputFile = "C:\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\destination.txt";  // converted file

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // ===== Open streams =====
            br = new BufferedReader(new FileReader(inputFile));
            bw = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = br.readLine()) != null) {
                // Convert uppercase letters to lowercase
                String lowerLine = line.toLowerCase();
                bw.write(lowerLine);
                bw.newLine(); // preserve line breaks
            }

            System.out.println("File conversion completed. Check " + outputFile);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
