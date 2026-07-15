class Solution {
    public int countSubstrings(String s) {
        int mid = 0;
        int counter = 0;
        while (mid < s.length()) {
            // odd substring
            int left = mid;
            int right = mid;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                counter++;
                left--;
                right++;
            }

            // even substring
            left = mid;
            right = mid+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                counter++;
                left--;
                right++;
            }
            mid++;
        }
        

        return counter;
    }
}

