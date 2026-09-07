class Solution {

    boolean find(int[] nums, int threshold, int mid) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += (nums[i] + mid - 1) / mid;

            if (sum > threshold) {
                return false;
            }
        }

        return true;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;

        int s = 1;
        int e = -1;
        int ans = -1;

        // Find maximum element
        for (int i = 0; i < n; i++) {
            e = Math.max(nums[i], e);
        }

        while (s <= e) {

            int mid = s + (e - s) / 2;

            boolean flag = find(nums, threshold, mid);

            if (flag == true) {

                ans = mid;
                e = mid - 1;

            } else {

                s = mid + 1;
            }
        }

        return ans;
    }
}