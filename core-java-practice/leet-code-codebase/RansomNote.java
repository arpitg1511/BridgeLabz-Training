class Solution {
    public boolean canConstruct(String rn, String mg) {
        if(rn.length() > mg.length()) return false;

        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : mg.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(char ch : rn.toCharArray()) {
            if(!mp.containsKey(ch)) return false;

            int a = mp.get(ch);
            mp.put(ch, a - 1);

            if(a - 1 == 0) {
                mp.remove(ch);
            }
        }

        return true;
    }
}