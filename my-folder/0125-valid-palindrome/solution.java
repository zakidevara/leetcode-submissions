class Solution {
    public boolean isPalindrome(String s) {
        int headIndex = 0;
        int tailIndex = s.length()-1;
        while (headIndex < tailIndex) {
            char head = s.charAt(headIndex);
            char tail = s.charAt(tailIndex);

            while (!Character.isLetterOrDigit(head)) {
                if (headIndex == s.length()-1) break;
                headIndex++;
                head = s.charAt(headIndex);
            }

            while (!Character.isLetterOrDigit(tail)) {
                if (tailIndex == 0) break;
                tailIndex--;
                tail = s.charAt(tailIndex);
            }

            if (!Character.isLetterOrDigit(head) && !Character.isLetterOrDigit(tail)) {
                break;
            }

            if (!(Character.toLowerCase(head) == Character.toLowerCase(tail))) {
                return false;
            }

            headIndex++;
            tailIndex--;
        }
        return true;
    }
}
