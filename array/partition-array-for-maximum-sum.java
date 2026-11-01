class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;
        
        // dp[i] = maximum sum for first i elements
        int[] dp = new int[n + 1];
        
        // Consider each ending position
        for (int i = 1; i <= n; i++) {
            
            int maxVal = 0;
            
            // Try partition lengths from 1 to k
            for (int len = 1; len <= k && i - len >= 0; len++) {
                
                // Maximum value in the current partition
                maxVal = Math.max(maxVal, arr[i - len]);
                
                // Current partition contributes len * maxVal
                dp[i] = Math.max(
                    dp[i],
                    dp[i - len] + len * maxVal
                );
            }
        }
        
        return dp[n];
    }
}