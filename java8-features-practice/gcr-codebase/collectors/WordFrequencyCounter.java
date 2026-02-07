import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String paragraph = "java is fun and java is powerful";

        Map<String, Integer> wordCount =
                Arrays.stream(paragraph.split("\\s+"))
                      .collect(Collectors.toMap(
                              word -> word,      // key
                              word -> 1,         // initial value
                              (count1, count2) -> count1 + count2  // merge logic
                      ));

        wordCount.forEach((word, count) ->
                System.out.println(word + " -> " + count)
        );
    }
}
