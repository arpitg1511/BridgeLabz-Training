import java.util.*;

public class SortStackUsingRecursion {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		
		st.push(20);
		st.push(1);
		st.push(40);
		st.push(10);
		st.push(1000);
		st.push(300);
		st.push(400);
		
		System.out.println(st);
		sort(st);
		System.out.println(st);
	}
	
	public static void sort(Stack<Integer> st) {
		if(st.isEmpty()) return;
		
		int top = st.pop();
		sort(st);
		insert(st, top);
		return;
	}
	
	public static void insert(Stack<Integer> st, int top) {
		if(st.isEmpty() || st.peek() <= top) {
			st.push(top);
			return;
		}
		
		int top2 = st.pop();
		insert(st, top);
		st.push(top2);
		
		return;
	}
}