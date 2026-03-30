import java.util.*;

public class RotateElement {

	public static <T> void rotateList(List<T> list, int rotate) {
		int n = list.size();
		rotate = rotate % n;
		reverse(list, 0, rotate - 1);
		reverse(list, rotate, n - 1);
		reverse(list, 0, n - 1);
	}

	public static <T> void reverse(List<T> list, int start, int end) {
		while (start < end) {
			T temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
		int rotate = 2;

		rotateList(list, rotate);
		System.out.println(list);
	}
}