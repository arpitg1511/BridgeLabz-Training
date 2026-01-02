import java.util.*;

public class ParagraphAnalysis {

    // Main method for testing
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String paragraph = sc.nextLine();
        String wordToReplace = sc.next();
        String replacement = sc.next();

        analyzeText(paragraph, wordToReplace, replacement);
        
        sc.close();
    }

    public static void analyzeText(String paragraph, String wordToReplace, String replacement) {

        // Edge case: null, empty, or only spaces
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("Paragraph is empty or contains only spaces.");
            return;
        }

        // Normalize spaces
        String cleanedParagraph = paragraph.trim().replaceAll("\\s+", " ");

        // Split words (handles punctuation)
        String[] words = cleanedParagraph.split("\\W+");

        // 1️⃣ Word Count
        int wordCount = words.length;

        // 2️⃣ Longest Word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // 3️⃣ Replace word (case-insensitive)
        String replacedParagraph = cleanedParagraph.replaceAll(
                "(?i)\\b" + wordToReplace + "\\b",
                replacement
        );

        // Output
        System.out.println("Original Paragraph:");
        System.out.println(cleanedParagraph);

        System.out.println("\nWord Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);

        System.out.println("\nParagraph After Replacement:");
        System.out.println(replacedParagraph);
    }
}
