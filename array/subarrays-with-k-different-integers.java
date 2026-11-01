import java.util.HashMap;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    // Helper function
    private int atMostK(int[] nums, int k) {

        if (k < 0) return 0;

        int left = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {

            // Add right element
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Shrink window if distinct > k
            while (map.size() > k) {

                map.put(nums[left], map.get(nums[left]) - 1);

                // REMOVE ONLY when count becomes 0
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            // Count subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
