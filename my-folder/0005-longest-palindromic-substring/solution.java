class Solution {
    public String longestPalindrome(String s) {
        int mid = 0;
        String longestPalindrome = String.valueOf(s.charAt(mid));
        while (mid < s.length()) {
            // odd substring
            int left = mid;
            int right = mid;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (longestPalindrome.length() < right - left + 1) {
                    longestPalindrome = s.substring(left, right+1);
                }
                left--;
                right++;
            }

            // even substring
            left = mid;
            right = mid+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (longestPalindrome.length() < right - left + 1) {
                    longestPalindrome = s.substring(left, right+1);
                }
                left--;
                right++;
            }
            mid++;
        }
        

        return longestPalindrome;
    }
}
