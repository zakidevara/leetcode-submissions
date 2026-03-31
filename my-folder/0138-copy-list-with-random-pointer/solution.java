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
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node currCopy = new Node(curr.val);
            currCopy.next = curr.next;
            curr.next = currCopy;
            
            curr = currCopy.next;
        }

        curr = head;
        while(curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            if (curr.next != null) {
                curr = curr.next.next;
            }
        }

        Node oldHead = head;
        Node newHead = head.next;
        Node currOld = oldHead;
        Node currNew = newHead;

        while (currOld != null) {
            currOld.next = currOld.next.next;
            currNew.next = currNew.next != null ? currNew.next.next : null;
            currOld = currOld.next;
            currNew = currNew.next;
        }

        return newHead;

    }
}
