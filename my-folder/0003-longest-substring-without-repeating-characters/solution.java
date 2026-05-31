class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (lastSeen.get(curr) != null) {
                left = Math.max(left, lastSeen.get(curr) + 1);
            } 
            
            lastSeen.put(curr, right);

            maxLength = Math.max(right-left + 1, maxLength);

            right++;
        }

        return maxLength;
    }
}
