class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int res = 0;

        for (int price : prices) {
            if (price < minSoFar) {
                minSoFar = price;
            }
            res = Math.max(res, price - minSoFar);
        }
        return res;
    }
}
