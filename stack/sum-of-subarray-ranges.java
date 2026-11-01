class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long maxSum = 0, minSum = 0;

        // ----- MINIMUM CONTRIBUTION -----
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        java.util.Stack<Integer> st = new java.util.Stack<>();

        // previous smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            leftMin[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        // next smaller or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            rightMin[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            minSum += (long) nums[i] * leftMin[i] * rightMin[i];
        }

        // ----- MAXIMUM CONTRIBUTION -----
        st.clear();
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // previous greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            leftMax[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        // next greater or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            rightMax[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            maxSum += (long) nums[i] * leftMax[i] * rightMax[i];
        }

        return maxSum - minSum;
    }
}
