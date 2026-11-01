class Solution {
    public int[] moveZeroes(int[] nums) {
        int temp;
        for(int j=0;j<nums.length-1;j++){
            for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0&& i!=nums.length-1){
                temp=nums[i];
               
                nums[i]=nums[i+1];
                nums[i+1]=temp;
            }
        }}
       return nums; 
    }
    public static void main (String args[]){
        Solution ob=new Solution();
         int arr[]={1,2,3,4,5,6,0,0,9,8,7};
         ob.moveZeroes(arr);
    }
}