class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        int[] bits = new int[(n >> 5) + 1]; // n / 32
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!isComposite(bits, i)) {
                count++;

                // Mark multiples
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        setComposite(bits, j);
                    }
                }
            }
        }
        return count;
    }

    private boolean isComposite(int[] bits, int num) {
        return (bits[num >> 5] & (1 << (num & 31))) != 0;
    }

    private void setComposite(int[] bits, int num) {
        bits[num >> 5] |= (1 << (num & 31));
    }
}
