import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReaderVsInputStreamReader {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\disco\\OneDrive\\Desktop\\data.txt";

        // -------- FileReader --------
        long startFR = System.currentTimeMillis();
        int wordsFR = countWordsUsingFileReader(filePath);
        long endFR = System.currentTimeMillis();

        System.out.println("FileReader Words: " + wordsFR);
        System.out.println("FileReader Time: " + (endFR - startFR) + " ms");

        // -------- InputStreamReader --------
        long startISR = System.currentTimeMillis();
        int wordsISR = countWordsUsingInputStreamReader(filePath);
        long endISR = System.currentTimeMillis();

        System.out.println("InputStreamReader Words: " + wordsISR);
        System.out.println("InputStreamReader Time: " + (endISR - startISR) + " ms");
    }

    // FileReader method
    static int countWordsUsingFileReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        return countWords(br);
    }

    // InputStreamReader method
    static int countWordsUsingInputStreamReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path),
                        StandardCharsets.UTF_8
                )
        );
        return countWords(br);
    }

    // Common word counting logic
    static int countWords(BufferedReader br) throws IOException {
        int count = 0;
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            if (!line.isBlank()) {
                count += words.length;
            }
        }
        br.close();
        return count;
    }
}
