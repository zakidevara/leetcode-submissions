class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head; // head is the oldest node in the cache
    private Node tail; // tail is the newest node added to the cache

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            
            if (tail == n) return n.val;

            // move n to the tail of the list
            Node prev = n.prev;
            Node next = n.next;

            if (prev != null) {
                prev.next = next;
            } else {
                head = next;
            }

            if (next != null) {
                next.prev = prev;
            }

            n.prev = tail;
            n.next = null;
            tail.next = n;
            tail = n;

            return n.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // remove existing node from linked list
            Node toRemove = map.get(key);
            removeNode(toRemove);
        }

        Node newNode = new Node(key, value, null, tail);

        if (head == null) head = newNode;
        if (tail != null) tail.next = newNode;
        tail = newNode;
        map.put(key, newNode);

        // remove head if over capacity
        if (map.size() > capacity) {
            Node currHead = head;
            head = head.next;
            if (head != null && head.prev != null) head.prev = null;

            map.remove(currHead.key);
            currHead = null;
        }
    }

    private void removeNode(Node n) {
        // move n to the tail of the list
        Node prev = n.prev;
        Node next = n.next;

        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = prev;
        }

        map.remove(n.key);

        if (head == n) {
            head = head.next;
        }
        if (tail == n) {
            tail = tail.prev;
        }
    }

    private class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
