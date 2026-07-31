class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a'] += 1;
        }
        
        int oddCount = 0;
        for (int count : chars) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= k;
        
    }
}
