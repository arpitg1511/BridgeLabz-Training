
public class CensorWords {
    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";
        
        // List of bad words
        String[] badWords = {"damn", "stupid"};
        
        // Loop through each bad word and replace it with "****"
        for (String bad : badWords) {
            sentence = sentence.replaceAll("(?i)\\b" + bad + "\\b", "****");
        }
        
        System.out.println(sentence);
    }
}
