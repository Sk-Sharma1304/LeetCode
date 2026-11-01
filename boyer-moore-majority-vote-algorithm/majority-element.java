class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int c=0;
        int ele=0;

        for(int i=0;i<n;i++){
            if(c==0){
                c=1;
                ele=nums[i];
            }
            else if(ele==nums[i])
            c++;
            else
            c--;
        }

        int c1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele)
            c1++;
        }

        if(c1>(n/2))
        return ele;

        return -1;
    }
}