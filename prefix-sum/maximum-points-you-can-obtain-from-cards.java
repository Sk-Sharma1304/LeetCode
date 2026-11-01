class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Step 1: Total sum of all cards
        int totalSum = 0;
        for (int x : cardPoints) {
            totalSum += x;
        }

        // If we take all cards
        if (k == n) return totalSum;

        int windowSize = n - k;
        int windowSum = 0;

        // Step 2: First window sum
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        // Step 3: Slide the window
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        // Step 4: Result
        return totalSum - minWindowSum;
    }
}
