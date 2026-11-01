class Solution {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) return 1.0;

        // Handle negative exponent
        long exp = n; // use long to handle Integer.MIN_VALUE
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result *= x;   // If the current bit is set
            }
            x *= x;            // Square the base
            exp /= 2;          // Move to the next bit
        }

        return result;
    }
}
