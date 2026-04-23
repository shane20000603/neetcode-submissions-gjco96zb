/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        HashMap<Node, Node> map = new HashMap();
        Node cur = head;
        Node pointer = dummy;
        while(cur != null){
            Node next = new Node(cur.val);
            map.put(cur, next);
            pointer.next = next;
            pointer = pointer.next;
            cur = cur.next;
        }
        pointer = dummy.next;
        cur = head;
        while(cur != null){
            pointer.random = map.get(cur.random);
            pointer = pointer.next;
            cur = cur.next;
        }
        return dummy.next;


    }
}
