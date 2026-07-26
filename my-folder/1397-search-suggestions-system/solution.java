class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = buildTrie(products);
        List<List<String>> result = new ArrayList<>();
        StringBuilder currQuery = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            currQuery.append(c);
            result.add(autoComplete(root, currQuery.toString()));
        }
        
        return result;
    }
    
    
    private List<String> autoComplete(TrieNode root, String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.childrens[c - 'a'] == null) {
                return List.of();
            }
            curr = curr.childrens[c - 'a'];
        }
            
        
            
        List<String> result = new ArrayList<>(curr.recommendations).subList(0, Math.min(3, curr.recommendations.size()));
        
        return result;
    }
    
    private TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode(' ');
        for (String product : products) {
            
            TrieNode curr = root;
            for (char c : product.toCharArray()) {
                if (curr.childrens[c - 'a'] == null) {
                    curr.childrens[c - 'a'] = new TrieNode(c);
                }
                curr = curr.childrens[c - 'a'];
                curr.recommendations.add(product);
            }
            
            curr.isWord = true;
        }
        
        return root;
    }
    
    private class TrieNode {
        char val;
        TrieNode[] childrens;
        SortedSet<String> recommendations;
        boolean isWord;
        
        public TrieNode(char val) {
            this.val = val;
            this.recommendations = new TreeSet<>();
            this.childrens = new TrieNode[26];
        }
    }
}
