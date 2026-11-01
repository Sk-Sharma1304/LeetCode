class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
    int n = nums.length;
    int[] result = new int[n - k + 1];
    
    for (int i = 0; i < n; i++) {
        // Remove indices outside window
        if (!deque.isEmpty() && deque.peekFirst() == i - k)
            deque.pollFirst();

        // Remove smaller elements
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
            deque.pollLast();

        deque.offerLast(i);

        if (i >= k - 1)
            result[i - k + 1] = nums[deque.peekFirst()];
    }
    return result;
        
    }
}