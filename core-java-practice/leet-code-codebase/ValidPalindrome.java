class Solution {
    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        String s = "";
        for(int i = 0; i < str.length(); i++) {
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || 
            (str.charAt(i) >= '0' && str.charAt(i) <= '9')) s += str.charAt(i);
        }
        return helper(s, 0, s.length() - 1);
    }

    public boolean helper(String s, int i, int j) {
        if(i >= j) return true;

        if(s.charAt(i) != s.charAt(j)) return false;

        return helper(s, i + 1, j - 1);
    }
}