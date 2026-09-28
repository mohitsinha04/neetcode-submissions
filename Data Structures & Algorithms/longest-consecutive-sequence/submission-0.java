class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> freq = new HashSet<>();
        for (int i : nums) freq.add(i);
        int res = 0;
        for (int i : nums) {
            int curr = i;
            int count = 0;
            if (!freq.contains(curr - 1)) {
                while (freq.contains(curr)) {
                    count++;
                    curr++;
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
