class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for(int n:nums)
        totalSum+=n;

        if(Math.abs(target)>totalSum)
        return 0;

        if((totalSum+target)%2!=0)
        return 0;
        int subsetSum=(totalSum+target)/2;
        int dp[]=new int[subsetSum+1];
        dp[0]=1;

        for(int n: nums){
            for(int sum=subsetSum;sum>=n;sum--)
            dp[sum]=dp[sum]+dp[sum-n];
        }
        return dp[subsetSum];
    }
}