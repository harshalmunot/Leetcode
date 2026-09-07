class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;

        long[] last = new long[26];

        long dp = 1; // empty subsequence

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';

            long newDp = (2 * dp - last[c] + MOD) % MOD;

            last[c] = dp;
            dp = newDp;
        }

        // remove empty subsequence
        return (int) ((dp - 1 + MOD) % MOD);
    }
}