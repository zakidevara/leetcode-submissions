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
        Map<Node, Node> helperMap = new HashMap<>();
        
        Node curr = head;
        // create deep copy nodes mapping
        while (curr != null) {
            helperMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // link nodes in the deep copy
        curr = head;
        while(curr != null) {
            Node deepCopyNode = helperMap.get(curr);

            deepCopyNode.next = helperMap.get(curr.next);
            deepCopyNode.random = helperMap.get(curr.random);
            curr = curr.next;
        }

        return helperMap.get(head);
    }
}
