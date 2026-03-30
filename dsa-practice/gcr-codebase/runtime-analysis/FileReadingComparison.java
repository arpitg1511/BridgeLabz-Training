import java.io.*;

public class FileReadingComparison {

    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\disco\\OneDrive\\Desktop\\data.txt";
        System.out.println("Reading with FileReader:");
        long start = System.nanoTime();
        readWithFileReader(filePath);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms\n");

        System.out.println("Reading with InputStreamReader:");
        start = System.nanoTime();
        readWithInputStreamReader(filePath);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    // FileReader reading character by character
    public static void readWithFileReader(String filePath) throws IOException {
        try (FileReader fr = new FileReader(filePath)) {
            while (fr.read() != -1) {
                // just read, do nothing
            }
        }
    }

    // InputStreamReader reading byte stream
    public static void readWithInputStreamReader(String filePath) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            while (isr.read() != -1) {
                // just read, do nothing
            }
        }
    }
}
