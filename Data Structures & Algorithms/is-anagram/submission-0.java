class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) - 1);
        }

        for (char c : charFreq.keySet()) {
            if (charFreq.get(c) != 0) return false;
        }
        return true;
        
    }
}
