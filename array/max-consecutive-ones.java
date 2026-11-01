class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0; 
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++; 
                max = Math.max(max, currentCount); 
            } else {
                currentCount = 0; 
            }
        }

        return max; 
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 1, 1, 0, 1, 0, 1};
        Solution ob = new Solution();
        int result = ob.findMaxConsecutiveOnes(arr);
        System.out.println("Max Consecutive Ones: " + result);
    }
}