class StreamChecker {

    private TrieNode root;
    private Queue<TrieNode> queue;

    public StreamChecker(String[] words) {
        queue = new ArrayDeque<>();
        root = buildSuffixTrie(words);
    }
    
    public boolean query(char letter) {
        boolean found = false;
        int i = queue.size();
        if (root.childrens.containsKey(letter)) {
            queue.offer(root.childrens.get(letter));
            if (root.childrens.get(letter).isSuffix) found = true;
        }
        
        while (i > 0) {
            TrieNode curr = queue.poll();
            if (curr.childrens.containsKey(letter)) {
                curr = curr.childrens.get(letter);
                if (curr.isSuffix) found = true;
                if (curr.childrens.size() > 0) {
                    queue.offer(curr);
                }
            }

            i--;
        }

        return found;
    }

    private TrieNode buildSuffixTrie(String[] words) {
        TrieNode root = new TrieNode(' ', false);
        for (String word : words) {
            char[] charArray = word.toCharArray();
            TrieNode curr = root;
            for (int i = 0; i < charArray.length; i++) {
                if (!curr.childrens.containsKey(charArray[i])) {
                    curr.childrens.put(charArray[i], new TrieNode(charArray[i], false));
                }
                curr = curr.childrens.get(charArray[i]);
            }

            curr.isSuffix = true;
        }

        return root;
    }

    private class TrieNode {
        char value;
        boolean isSuffix;
        Map<Character, TrieNode> childrens;

        public TrieNode(char value, boolean isSuffix) {
            this.value = value;
            this.isSuffix = isSuffix;
            this.childrens = new HashMap<>();
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
