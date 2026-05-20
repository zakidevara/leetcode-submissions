class Solution {
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }

        return true;
    }
}
