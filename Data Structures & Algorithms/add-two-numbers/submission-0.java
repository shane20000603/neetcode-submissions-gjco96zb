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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1r = l1;
        ListNode dummy = l1r;
        ListNode l2r = l2;
        ListNode prev = null;
        int add = 0;
        while(l1r != null || l2r != null){
            int val = add;
            if(l1r != null){
                val += l1r.val;
            }
            if(l2r != null){
                val += l2r.val;
            }
            if(l1r != null){
                l1r.val = val % 10;
                prev = l1r;
                l1r = l1r.next;
                add = val / 10;
            } else {
                l2r.val = val % 10;
                prev.next = l2r;
                l1r = l2r;
                prev = l1r;
                l1r = l1r.next;
                l2r = l2r.next;
                add = val / 10;
            }
            if(l2r != null){
                l2r = l2r.next;
            }
        }
        System.out.println("add: "+add);
        if(add != 0){
            prev.next = new ListNode(1);
        }
        return dummy;
    }

    private ListNode reverse(ListNode l){
        ListNode prev = null;
        ListNode cur = l;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
