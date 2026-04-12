class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 1) return 1;
        Integer endIdx = null;
        Integer startIdx = null;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && endIdx == null) {
                endIdx = i+1;
            } 
            
            if (i == 0 && endIdx != null && s.charAt(i) != ' ') {
                startIdx = 0;
                break;
            } else if (s.charAt(i) == ' ' && endIdx != null) {
                startIdx = i + 1;
                break;
            }  
        }

        return endIdx - startIdx;
    }
}
