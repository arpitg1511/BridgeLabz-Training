class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] arrS = new int[26];

        for(char ch : s.toCharArray()) {
            arrS[ch - 'a'] += 1;
        }

        int[] arrTar = new int[26];
        for(char ch : target.toCharArray()) {
            arrTar[ch - 'a'] += 1;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {

            if(arrTar[i] > 0) {
                ans = Math.min(ans, arrS[i] / arrTar[i]);
            }

        }

        return ans;
    }
}