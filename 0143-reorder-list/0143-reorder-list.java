/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            list.get(left).next = list.get(right);
            left++;

            if (left == right) break;

            list.get(right).next = list.get(left);
            right--;
        }

        list.get(left).next = null;
    }
}