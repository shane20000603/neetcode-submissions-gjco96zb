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
        if(head.next == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cursor = dummy;
        for(int i = 0; i < n; i++){
            cursor = cursor.next;
        }
        System.out.println("cursor init: "+cursor.val);
        ListNode end = dummy;
        while(cursor != null && cursor.next != null){
            cursor = cursor.next;
            end = end.next;
            prev = prev.next;

        }
        System.out.println("cursor: "+cursor.val);
        System.out.println("end: "+end.val);
        ListNode delete = end.next;
        end.next = null;
        if(delete != null){
            ListNode next = delete.next;
            end.next = next;
        }
        return dummy.next;
    }
}
