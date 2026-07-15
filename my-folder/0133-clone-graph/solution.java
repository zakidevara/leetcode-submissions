/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new Node(node.val);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        Map<Integer, Node> newNodeMap = new HashMap<>();

        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node copy;
            if (newNodeMap.get(curr.val) != null) {
                copy = newNodeMap.get(curr.val);
            } else {
                copy = new Node(curr.val);
                newNodeMap.put(copy.val, copy);
            }

            List<Node> neighbors = curr.neighbors;
            if (neighbors.size() == copy.neighbors.size()) continue;

            for (Node n : neighbors) {
                if (newNodeMap.get(n.val) == null) {
                    Node nCopy = new Node(n.val);
                    newNodeMap.put(n.val, nCopy);
                    copy.neighbors.add(nCopy);
                    q.offer(n);
                } else {
                    Node nCopy = newNodeMap.get(n.val);
                    copy.neighbors.add(nCopy);
                }
            }
        }

        return newNodeMap.get(1);
    }
}
