class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold=-prices[0];
        int cash=0;

        for(int i=1;i<prices.length;i++){
            int oldHold=hold;
            int oldCash=cash;

            hold=Math.max(oldHold,oldCash-prices[i]);
            cash=Math.max(oldCash,oldHold+prices[i]-fee);
        }
        return cash;
    }
}