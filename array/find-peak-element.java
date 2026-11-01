class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // We are on an increasing slope
            if (nums[mid] < nums[mid + 1]) {
                // Peak must be on the right
                left = mid + 1;
            } 
            else {
                // Peak is at mid or on the left
                right = mid;
            }
        }

        return left;
    }
}