class Trie {
    
    private Node root;

    public Trie() {
        root = new Node(' ');
    }
    
    public void insert(String word) {
        Node curr = root;
        for (Character c : word.toCharArray()) {
            curr.childrens.computeIfAbsent(c, k -> new Node(c));
            curr = curr.childrens.get(c);
        }
        
        curr.isWord = true;
        
    }
    
    public boolean search(String word) {
        Node curr = root;
        for (Character c : word.toCharArray()) {
            if (!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }
        
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (Character c : prefix.toCharArray()) {
            if (!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
        }
        
        return true;
        
    }
    
    private class Node {
        Character val;
        Map<Character, Node> childrens;
        boolean isWord;
        
        public Node(Character val) {
            this.val = val;
            this.childrens = new HashMap<>();
            this.isWord = false;
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
