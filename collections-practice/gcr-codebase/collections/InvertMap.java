import java.util.*;

public class InvertMap {

    static Map<Integer, List<String>> invert(Map<String, Integer> input) {

        Map<Integer, List<String>> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : input.entrySet()) {

            String key = entry.getKey();
            int value = entry.getValue();

            // If value already exists, add key to its list
            if (result.containsKey(value)) {
                result.get(value).add(key);
            } else {
                // Create new list for this value
                List<String> list = new ArrayList<>();
                list.add(key);
                result.put(value, list);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);

        Map<Integer, List<String>> invertedMap = invert(map);

        System.out.println(invertedMap);
    }
}
