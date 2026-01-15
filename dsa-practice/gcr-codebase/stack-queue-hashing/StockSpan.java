import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        
        int[] arr = new int[]{100, 80, 60, 120};
        int[] ans = spanStock(arr);
        
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ans));
    }
    
    public static int[] spanStock(int[] arr) {
        // Handle empty input case
        if(arr.length == 0) return new int[] {};
        
        // Stack stores indices of elements
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            
            // Remove indices of elements smaller than current element
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            
            // If stack is empty, all previous elements are smaller
            // Otherwise, span is distance to the previous greater element
            int ele = st.isEmpty() ? i + 1 : i - st.peek();
            
            // Push current index to stack and update answer array
            st.push(i);
            ans[i] = ele;
        }
        
        return ans;
    }
}