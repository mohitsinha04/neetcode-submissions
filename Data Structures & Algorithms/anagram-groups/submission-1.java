class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> group = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String sorted = new String(arr);
            group.putIfAbsent(sorted, new ArrayList<>());

            group.get(sorted).add(s);
        }
        return new ArrayList<>(group.values());
    }
}
