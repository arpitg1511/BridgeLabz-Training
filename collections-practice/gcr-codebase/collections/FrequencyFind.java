import java.util.*;

public class FrequencyFind {

	public static <T> Map<T, Integer> findFrequency(List<T> list) {
		Map<T, Integer> map = new HashMap<T, Integer>();
		for (T s : list) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
		System.out.println(findFrequency(list));
	}

}