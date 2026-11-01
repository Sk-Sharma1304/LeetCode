class Solution {

    TrieNode root = new TrieNode();

    // Insert number into Binary Trie
    public void insert(int num) {

        TrieNode current = root;

        // Check bits from MSB to LSB
        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (current.children[bit] == null) {
                current.children[bit] = new TrieNode();
            }

            current = current.children[bit];
        }
    }

    // Find maximum XOR possible with num
    public int getMaxXor(int num) {

        TrieNode current = root;

        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            // To get XOR = 1, we need opposite bit
            int opposite = 1 - bit;

            if (current.children[opposite] != null) {

                // We successfully made this XOR bit 1
                maxXor = maxXor | (1 << i);

                current = current.children[opposite];

            } else {

                // Opposite doesn't exist
                // So use the same bit
                current = current.children[bit];
            }
        }

        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {

        // Step 1: Insert all numbers
        for (int num : nums) {
            insert(num);
        }

        int answer = 0;

        // Step 2: Find best XOR for every number
        for (int num : nums) {
            answer = Math.max(answer, getMaxXor(num));
        }

        return answer;
    }
}

class TrieNode {

    // Only two possibilities: 0 or 1
    TrieNode[] children = new TrieNode[2];
}