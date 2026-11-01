class Solution {
    public int change(int amount, int[] coins) {
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int current=coin;current<=amount;current++){
                dp[current]+=dp[current-coin];
            }
        }
        return dp[amount];
    }
}