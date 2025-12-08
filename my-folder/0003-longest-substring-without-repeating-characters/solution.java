class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int[] lastSeenAt = new int[128];
        
        Arrays.fill(lastSeenAt, -1);
        
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            
            if (lastSeenAt[curr] != -1) {
                left = Math.max(left, lastSeenAt[curr] + 1);
            }

            lastSeenAt[curr] = right;
            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
