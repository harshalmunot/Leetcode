class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = 0;

        // Maximum possible speed
        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        while (start < end) {

            int mid = start + (end - start) / 2;

            long hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                // mid is possible, try a smaller speed
                end = mid;
            } else {
                // mid is too slow
                start = mid + 1;
            }
        }

        return start;
    }
}