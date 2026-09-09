class Solution {
    public long countCommas(long n) {
        long count = 0;
        long x = 1000;

        while (x <= n) {
            count += n - x + 1;
            x *= 1000;
        }

        return count;
    }
}