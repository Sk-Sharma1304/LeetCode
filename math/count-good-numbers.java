class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2; // even indices count
        long odd = n / 2;        // odd indices count

        long evenWays = power(5, even);
        long oddWays = power(4, odd);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
