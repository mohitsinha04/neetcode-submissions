class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] chars = new int[26];
            for (char c : s.toCharArray()) {
                chars[c - 'a']++;
            }
            String curr = Arrays.toString(chars);
            res.putIfAbsent(curr, new ArrayList<>());
            res.get(curr).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
