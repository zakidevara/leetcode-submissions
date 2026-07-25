class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = -1;
        int right = 0;
        int max = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                left = right;
            } else {
                max = Math.max(max, right-left);
            }
            right++;
        }

        return max;
    }
}
