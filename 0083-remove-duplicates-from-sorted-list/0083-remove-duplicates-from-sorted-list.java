class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode temp = head.next;
        while(temp != null){
            if(prev.val==temp.val){
                prev.next=temp.next;
                temp=prev.next;
            }
            else{
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}