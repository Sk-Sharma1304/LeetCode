class Solution {
    public int hIndex(int[] arr) {
        int n = arr.length; // Number of papers
        int ans[] = new int[n + 1]; // Array to store the frequency of citations

        // Fill the frequency array
        for (int i = 0; i < n; i++) {
            int k = arr[i]; // Current citation count
            if (k > n) {
                // If the citation count is greater than the number of papers,
                // increment the count for 'n' (excessive citations are treated as 'n')
                ans[n]++;
            } else {
                // Increment the count for the specific citation number 'k'
                ans[k]++;
            }
        }

        int c = 0; // Variable to accumulate the count of papers with at least 'j' citations

        // Traverse from the highest possible H-Index to the lowest
        for (int j = n; j >= 0; j--) {
            c += ans[j]; // Accumulate the count of papers with at least 'j' citations

            // If the number of papers with at least 'j' citations is greater than or equal to 'j',
            // return 'j' as the H-Index
            if (c >= j) {
                return j;
            }
        }

        // If no valid H-Index is found, return 0
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5}; // Example input
        Solution obj = new Solution();
        int hIndex = obj.hIndex(citations);
        System.out.println("The H-Index is: " + hIndex); // Expected output: 3
    }
}