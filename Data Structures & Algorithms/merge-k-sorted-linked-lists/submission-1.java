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
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = left + (right - left)/2;
        ListNode m1 = merge(lists, left, mid);
        ListNode m2 = merge(lists, mid + 1, right);
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
