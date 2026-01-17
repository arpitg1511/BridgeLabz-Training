public class WordSearch {

    public static void main(String[] args) {

        String[] sentences = {
            "Java is a powerful programming language",
            "Data structures and algorithms are important",
            "Linear search is simple to understand",
            "Practice makes a man perfect"
        };

        String wordToSearch = "algorithms";

        String result = findSentence(sentences, wordToSearch);
        System.out.println(result);
    }

    // Linear Search method
    public static String findSentence(String[] sentences, String word) {

        for (String sentence : sentences) {

            // Case-insensitive word search
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }

        return "Not Found";
    }
}
