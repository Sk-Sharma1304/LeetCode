class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int num:nums)
        xor^=num;
        int diff=xor & -xor;
        int a=0,b=0;
        for(int num:nums){
            if((num & diff)==0){
                a^=num;
            }
            else{
                b^=num;
            }
        }
        return a<b?new int[]{a,b}:new int[]{b,a};
    }
}