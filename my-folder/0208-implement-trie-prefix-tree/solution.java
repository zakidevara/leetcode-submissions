class Trie {

    private Node root;

    public Trie() {
        root = new Node(null);
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node curr = root;
        for (char c : chars) {
            if (!curr.childrens.containsKey(c)) {
                curr.childrens.put(c, new Node(c));
            }
            curr = curr.childrens.get(c);
        }

        curr.isWord = true;

    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        
        Node curr = root;
        for (char c : chars) {
            if (!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        
        Node curr = root;
        for (char c : chars) {
            if (!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }

        return true;

    }

    private class Node {
        Character val;

        Map<Character, Node> childrens = new HashMap<>();
        boolean isWord = false;

        public Node(Character val) {
            this.val = val;
        }

        public boolean equals(Node o) {
            return o.val == this.val;
        }
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
