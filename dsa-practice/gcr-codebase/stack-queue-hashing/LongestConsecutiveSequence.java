import java.util.*;
public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] arr = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(arr));
	}
	
	public static int longestConsecutive(int[] arr) {
		
		//Set to store unique elements
        Set<Integer> set = new HashSet<>();
        for(int i : arr) set.add(i);

        int ans = 0;
        for(int i : arr) {
        	
        	//Check for Consecutive Elements
            if(!set.contains(i - 1)) {
                int j = i + 1;
                
            	//Check for Consecutive Elements
                while(set.contains(j)) {
                    j++;
                }
                if(j - i > ans) ans = j - i;
            }
        }

        return ans;
    }
}
