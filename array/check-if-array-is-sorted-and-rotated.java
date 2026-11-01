class Solution {
    public boolean check(int[] nums) {
        int countBreaks = 0; // Count the number of rotation points
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Check if the order breaks at nums[i]
            if (nums[i] > nums[(i + 1) % n]) {
                countBreaks++;
            }

            // If there are more than 1 breaks, it's not rotated non-decreasing
            if (countBreaks > 1) {
                return false;
            }
        }

        return true; // If the loop completes with 0 or 1 breaks, return true
    }

    public static void main(String[] args) {
        Solution ob = new Solution();

        int[] nums1 = {3, 4, 5, 1, 2}; // Rotated sorted array
        int[] nums2 = {2, 1, 3, 4, 5}; // Not a valid rotation
        int[] nums3 = {1, 2, 3, 4, 5}; // Sorted, not rotated

        System.out.println(ob.check(nums1)); // Output: true
        System.out.println(ob.check(nums2)); // Output: false
        System.out.println(ob.check(nums3)); // Output: true
    }
}