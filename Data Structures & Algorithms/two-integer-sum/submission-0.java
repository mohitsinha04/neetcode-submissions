class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i]) && indexMap.get(target - nums[i]) != i) {
                res[0] = indexMap.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            indexMap.put(nums[i], i);
        }
        return res;
    }
}
