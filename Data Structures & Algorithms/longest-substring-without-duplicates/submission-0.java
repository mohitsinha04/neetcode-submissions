class Solution {
    public int lengthOfLongestSubstring(String s) {
        int winstart = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int winend = 0; winend < s.length(); winend++) {
            if (map.containsKey(s.charAt(winend))) {
                winstart = Math.max(winstart, map.get(s.charAt(winend)) + 1);
            }
            maxLen = Math.max(winend - winstart + 1, maxLen);
            map.put(s.charAt(winend), winend);
        }
        return maxLen;
    }
}
