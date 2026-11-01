class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor=0;
        for(int n:nums){
            xor^=n;
        }
        return xor;
    }
}