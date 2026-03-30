class Solution {
    public int lengthOfLastWord(String s) {
        int start = s.length() - 1;
        while(s.charAt(start) == ' ') start--;

        if(start == 0) return 1;

        int ans = 0;
        for(int i = start; i >= 0; i--) {
            if(s.charAt(i) == ' ') return ans;
            ans++;
        }

        return ans;
    }
}