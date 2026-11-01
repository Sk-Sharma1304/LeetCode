class Solution {
    public int divide(int dividend, int divisor) {

        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Convert to long & absolute values
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        // Subtraction with bit shifting
        while (a >= b) {
            long temp = b;
            int multiple = 1;

            // Double divisor until it exceeds dividend
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract largest chunk
            a -= temp;
            result += multiple;
        }

        // Apply sign
        return (dividend < 0 ^ divisor < 0) ? -result : result;
    }
}
