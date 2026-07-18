class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            Character curr = s.charAt(right);
            if (lastSeen.containsKey(curr)) {
                left = Math.max(left, lastSeen.get(curr) + 1);
            }
            
            lastSeen.put(curr, right);
            maxLength = Math.max(maxLength, right-left+1);
            
            
            right++;
        }
       
        return maxLength;
    }
}
