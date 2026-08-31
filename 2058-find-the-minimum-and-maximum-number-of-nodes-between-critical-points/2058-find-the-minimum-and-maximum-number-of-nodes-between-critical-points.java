class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1, prev = -1, min = Integer.MAX_VALUE;
        int idx = 1;

        ListNode a = head, b = head.next;

        while (b != null && b.next != null) {
            if ((b.val > a.val && b.val > b.next.val) ||
                (b.val < a.val && b.val < b.next.val)) {

                if (first == -1) first = idx;
                else min = Math.min(min, idx - prev);

                prev = idx;
            }

            a = b;
            b = b.next;
            idx++;
        }

        if (first == -1 || first == prev)
            return new int[]{-1, -1};

        return new int[]{min, prev - first};
    }
}