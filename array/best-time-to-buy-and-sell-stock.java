class Solution {
    public int maxProfit(int[] prices) {
        int s = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - s;
            max = Math.max(max, diff);
            s = Math.min(s, prices[i]);
        }

        return max;
    }
}