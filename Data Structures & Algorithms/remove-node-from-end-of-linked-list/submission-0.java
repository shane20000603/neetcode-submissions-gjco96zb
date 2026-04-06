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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, reverse(head));
        ListNode cur = dummy;
        while(--n > 0){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}
