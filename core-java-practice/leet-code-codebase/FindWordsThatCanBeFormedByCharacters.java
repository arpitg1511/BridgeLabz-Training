class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> mpChar = new HashMap<>();
        for(char ch : chars.toCharArray()) {
            mpChar.put(ch, mpChar.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        for(String word : words) {

            boolean isValid = true;
            Map<Character, Integer> mpWord = new HashMap<>(mpChar);
            for(char ch : word.toCharArray()) {

                if(!mpWord.containsKey(ch)) {
                    isValid = false;
                    break;
                }

                int ag = mpWord.get(ch);
                mpWord.put(ch, ag - 1);
                if(ag == 1) {
                    mpWord.remove(ch);
                }
            }

            if(isValid)
            ans += word.length();
        }

        return ans;
    }
}