class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");

        Map<Character, String> mpPattern = new HashMap<>();

        if(pattern.length() != str.length) return false;

        int idx = 0;
        for(char ch : pattern.toCharArray()) {
            if(mpPattern.containsKey(ch)) {
                if(!mpPattern.get(ch).equals(str[idx])) return false;
            }

            mpPattern.put(ch, str[idx]);
            idx++;
        }

        Map<String, Character> mpS = new HashMap<>();

        idx = 0;
        for(String sr : str) {
            if(mpS.containsKey(sr)) {
                if(mpS.get(sr) != pattern.charAt(idx)) return false;
            }

            mpS.put(sr, pattern.charAt(idx));
            idx++;
        }
    
        return true;
    }
}