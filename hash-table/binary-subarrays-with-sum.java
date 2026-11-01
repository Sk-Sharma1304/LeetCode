class Solution {

    // Main function
    public int numSubarraysWithSum(int[] nums, int goal) {
        // subarrays with sum == goal
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    // Counts subarrays with sum <= k
    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;   // important edge case

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // shrink window if sum exceeds k
            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            // all subarrays ending at 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }
}
