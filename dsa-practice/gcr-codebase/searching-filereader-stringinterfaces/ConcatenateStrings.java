import java.util.*;
public class ConcatenateStrings {
	public static void main(String[] args) {
		String[] strs = {"Java", "is", "a", "programming", "language"};
		StringBuffer sb = new StringBuffer();
		
		for(String str : strs) {
			sb.append(str);
			sb.append(' ');
		}
		
		System.out.println(sb.toString());
	}
}
