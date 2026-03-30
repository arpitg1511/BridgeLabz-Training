import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FrequencyCount {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\disco\\OneDrive\\Desktop\\data.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                // Convert to lowercase
                line = line.toLowerCase();

                // Remove punctuation
                line = line.replaceAll("[^a-z ]", "");

                // Split into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.length() == 0) {
                        continue;
                    }

                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File not found or error reading file");
        }

        // Print result
        System.out.println("Word Frequencies:");
        System.out.println(map);
    }
}
