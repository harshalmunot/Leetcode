class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode tail = curr;

            while (tail.next != null && tail.next.next != null) {
                tail = tail.next;
            }

            ListNode last = tail.next;

            if (last == null) break;

            tail.next = null;

            last.next = curr.next;
            curr.next = last;

            curr = last.next;
        }
    }
}