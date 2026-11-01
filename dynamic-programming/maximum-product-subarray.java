class Solution {
    public int maxProduct(int[] nums) {
       int max=nums[0];
       int min=nums[0];
       int ans=nums[0];

        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            int tempMax=max;
            int tempMin=min;

            max=Math.max(curr,Math.max(curr*tempMax,curr*tempMin));
            min=Math.min(curr,Math.min(curr*tempMax,curr*tempMin));

            ans=Math.max(ans,max);
        }
        return ans;
    }
}