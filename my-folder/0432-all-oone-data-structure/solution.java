class AllOne {
    
    private Node head;
    private Node tail;
    private Map<String, Node> map; // key to node/freq bucket

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public void inc(String key) {
        // check map
        Node currBucket = map.get(key);

        // if not exist, put to the 1 node and update the map
        Node nextBucket = null;
        if (currBucket == null) {
            if (head.next.count != 1)
                nextBucket = insertNodeAfter(head, 1);
            else 
                nextBucket = head.next;
        } else {
            if (currBucket.next.count - currBucket.count == 1) 
                nextBucket = currBucket.next;
            else {
                nextBucket = insertNodeAfter(currBucket, currBucket.count+1);
            }
        }

        nextBucket.keys.add(key);
        map.put(key, nextBucket);
        if (currBucket != null) {
            currBucket.keys.remove(key);
            removeNodeIfEmpty(currBucket);
        }

    }
    
    public void dec(String key) {
        // check map
        Node currBucket = map.get(key);

        // if not exist, immediately return
        Node prevBucket = null;
        if (currBucket == null) {
            return;
        }


        if (currBucket.count - currBucket.prev.count == 1) 
            prevBucket = currBucket.prev;
        else
            prevBucket = insertNodeBefore(currBucket, currBucket.count-1);
        

        
        if (prevBucket.count > 0) {
            prevBucket.keys.add(key);
            map.put(key, prevBucket);
        } else {
            map.remove(key);
        }
        currBucket.keys.remove(key);
        removeNodeIfEmpty(currBucket);
    }
    
    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }
    

    private class Node {
        int count;
        Set<String> keys; 
        Node prev;
        Node next;

        public Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }

        private String toStringList() {
            Node curr = this;
            StringBuilder sb = new StringBuilder();
            while (curr != null) {
                sb.append("<");
                sb.append("count=" + curr.count + ";");
                sb.append("keys=" + curr.keys + ";");
                sb.append(">");

                curr = curr.next;
            }

            return sb.toString();
        }
        
        private String toStringListReverse() {
            Node curr = this;
            StringBuilder sb = new StringBuilder();
            while (curr != null) {
                sb.append("<");
                sb.append("count=" + curr.count + ";");
                sb.append("keys=" + curr.keys + ";");
                sb.append(">");

                curr = curr.prev;
            }

            return sb.toString();
        }
    }

    private Node insertNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        Node next = prevNode.next;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = next;
        next.prev = newNode;
        return newNode;
    }

    
    private Node insertNodeBefore(Node nextNode, int count) {
        Node newNode = new Node(count);
        Node prev = nextNode.prev;

        nextNode.prev = newNode;
        newNode.next = nextNode;
        newNode.prev = prev;
        prev.next = newNode;

        return newNode;
    }

    private void removeNodeIfEmpty(Node node) {
        if (node.keys.isEmpty()) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
