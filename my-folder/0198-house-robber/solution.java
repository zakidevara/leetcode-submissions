class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];

        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            if (i == 2) {
                dp[i] = nums[i] + dp[i-2];
            } else {  
                dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
