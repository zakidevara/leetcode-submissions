class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // time complexity
        // O (n^2 . m) -> brute force using decision tree
        // O (n^2) -> convert dict to hashset, access to wordDict is now O(1)
        // O (n) -> using dp memoization

        Set<String> wordSet = new HashSet<>();
        for (String w : wordDict) {
            wordSet.add(w);
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for (int i = s.length()-1; i >= 0; i--) {
            for (String w : wordSet) {
                if (i + w.length() <= s.length() && w.equals(s.substring(i, i + w.length()))) {
                    dp[i] = dp[i + w.length()]; 
                }
                if (dp[i]) break;
            }
        }

        return dp[0];
    }

}

