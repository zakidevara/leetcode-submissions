import java.util.HashMap;
import java.util.Map;

class LFUCache {
    private class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            size++;
        }

        public void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        public Node removeLast() {
            if (size > 0) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }
            return null;
        }
    }

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> cache; // key to value
    private Map<Integer, DoublyLinkedList> freqMap; // freq to list of node with that frequency

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        // key exists
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            // over capacity
            if (cache.size() >= capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node evictedNode = minFreqList.removeLast();
                cache.remove(evictedNode.key);
            }

            // insert new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            minFreq = 1; 
            
            DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
            list.addFirst(newNode);
            freqMap.put(1, list);
        }
    }

    private void updateFreq(Node node) {
        int currentFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(currentFreq);
        oldList.removeNode(node);

        if (currentFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addFirst(node);
        freqMap.put(node.freq, newList);
    }
}
