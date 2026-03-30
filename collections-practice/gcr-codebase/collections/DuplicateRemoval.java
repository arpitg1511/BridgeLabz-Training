import java.util.*;

public class DuplicateRemoval {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
		removeDuplicates(list);
		System.out.println(list);
	}

	public static <T> void removeDuplicates(List<T> list) {
		Set<T> set = new HashSet<T>();
		for (int i = 0; i < list.size(); i++) {
			if (set.contains(list.get(i))) {
				list.remove(i);
				i--;
				continue;
			}
			set.add(list.get(i));
		}
	}
}