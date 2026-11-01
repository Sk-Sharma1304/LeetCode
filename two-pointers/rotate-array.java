class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // handle large k

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        // copy back to nums
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
