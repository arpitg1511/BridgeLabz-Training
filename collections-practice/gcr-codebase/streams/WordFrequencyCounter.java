import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String filename = "sample.txt"; // replace with your text file
        BufferedReader br = null;

        // HashMap to store word counts
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                // Remove punctuation, split by whitespace
                line = line.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue; // skip empty strings
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing BufferedReader: " + e.getMessage());
            }
        }

        // Sort words by frequency
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue()); // descending frequency

        System.out.println("Total words: " + wordCount.size());
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
s