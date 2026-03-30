import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputStreamReaderII {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\disco\\OneDrive\\Desktop\\data.txt";

        // Try-with-resources ensures proper closing of streams
        try (
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filePath, true) // append mode
        ) {

            String input;
            System.out.println("Enter text (type 'exit' to stop):");

            while (true) {
                input = br.readLine();

                // Stop condition
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }

                // Write input to file
                fw.write(input);
                fw.write(System.lineSeparator());
            }

            System.out.println("Input successfully written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
