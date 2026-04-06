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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists);
    }

    private ListNode merge(ListNode[] lists){
        if(lists.length <= 1) return lists[0];
        ListNode m1 = merge(Arrays.copyOfRange(lists, 0, lists.length/2));
        ListNode m2 = merge(Arrays.copyOfRange(lists, lists.length/2, lists.length));
        return mergeTwoList(m1, m2);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) cur.next = l1;
        if(l2 != null) cur.next = l2;
        return dummy.next;
    }
}
