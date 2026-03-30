class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mpS = new HashMap<>();
        Map<Character, Character> mpT = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);

            if(mpS.containsKey(cS) && mpS.get(cS) != cT) return false;
            if(mpT.containsKey(cT) && mpT.get(cT) != cS) return false;

            mpS.put(cS, cT);
            mpT.put(cT, cS);
        }

        return true;
    }
}