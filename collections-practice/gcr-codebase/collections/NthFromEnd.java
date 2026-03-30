import java.util.*;

public class NthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> list = new LinkedList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E'));
		int n = 2;
		System.out.println(findNthElementFromEnd(list, n));
	}

	public static <T> T findNthElementFromEnd(List<T> list, int n) {
		if (n <= 0) {
			return null;
		}
		Iterator<T> fast = list.iterator();
		Iterator<T> slow = list.iterator();

		for (int i = 0; i < n; i++) {
			if (!fast.hasNext()) {
				System.out.println("N greater than list");
				return null;
			}
			fast.next();
		}

		while (fast.hasNext()) {
			fast.next();
			slow.next();
		}
		return slow.next();
	}

}