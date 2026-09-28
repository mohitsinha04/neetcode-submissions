class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> group = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String sorted = new String(arr);
            List<String> curr = group.getOrDefault(sorted, new ArrayList<>());
            curr.add(s);
            group.put(sorted, curr);
        }
        for (String s : group.keySet()) {
            res.add(group.get(s));
        }
        return res;
    }
}
