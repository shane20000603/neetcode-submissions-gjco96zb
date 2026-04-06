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
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode reverse = reverseNode(mid);
        ListNode cur = head;
        int index = 0;
        ListNode dummy = new ListNode();
        while(cur != null && reverse != null){
            if(index % 2 == 0){
                dummy.next = cur;
                cur = cur.next;
            } else {
                dummy.next = reverse;
                reverse = reverse.next;
            }
            dummy = dummy.next;
            index++;
        }
        if(cur != null) dummy.next = cur;
        if(reverse != null) dummy.next = reverse;
    }

    private ListNode reverseNode(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
