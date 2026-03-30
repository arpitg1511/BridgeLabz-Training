import java.util.*;

public class MergeMaps {

    static Map<String, Integer> merge(Map<String, Integer> map1,
                                      Map<String, Integer> map2) {

        Map<String, Integer> result = new HashMap<>();

        // Copy all entries from map1
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        // Merge entries from map2
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {

            String key = entry.getKey();
            int value = entry.getValue();

            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> mergedMap = merge(map1, map2);

        System.out.println(mergedMap);
    }
}
