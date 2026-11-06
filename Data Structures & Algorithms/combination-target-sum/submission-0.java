class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, res, curr, target, 0);
        return res;
            
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        } if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, res, curr, target - nums[i], i);
            curr.removeLast();
        }

    }
}
