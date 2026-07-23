class Solution {
    public int firstUniqChar(String s) {
        int[] tracker = new int[26];
        Arrays.fill(tracker, -1);
        
        int i = 0;
        for (Character c : s.toCharArray()) {
            if (tracker[c - 'a'] == -1) {
                tracker[c - 'a'] = i;
            } else {
                tracker[c - 'a'] = Integer.MAX_VALUE;
            }
            i++;
        }
        
        int result = -1;
        for (int x : tracker) {
            if (x > -1) {
                
                if (result == -1 && x != Integer.MAX_VALUE) {
                    result = x;
                    continue;
                }
                result = Math.min(result, x);
            }
        }
        
        return result;
        
    }
}
