class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        // Initially, every element is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int maxLength = 1;
        int lastIndex = 0;

        // DP
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 &&
                    dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct answer
        List<Integer> ans = new ArrayList<>();

        while (parent[lastIndex] != lastIndex) {

            ans.add(nums[lastIndex]);

            lastIndex = parent[lastIndex];
        }

        // Add the first element
        ans.add(nums[lastIndex]);

        // We reconstructed backwards
        Collections.reverse(ans);

        return ans;
    }
}