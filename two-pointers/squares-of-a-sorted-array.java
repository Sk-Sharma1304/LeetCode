class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*nums[i];
        }
        int l=0;
        int r=n-1;
        int i=n-1;
        while(l<= r){
            if(nums[l]>nums[r]){
                result[i]=nums[l];
                i--;
                l++;
            }
            
            else{
                result[i]=nums[r];
                i--;
                r--;
            }
        }
        return result;
    }
}