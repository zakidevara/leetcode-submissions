class Solution {
    public int maxCoins(int[] nums) {
        int[][] memo = new int[nums.length+1][nums.length+1];
        return dp(nums, 0, nums.length, memo);
    }

    public int dp(int[] nums, int left, int right, int[][] memo) {
        if (right-left < 0) return 0;
        if (memo[left][right] > 0) 
            return memo[left][right];



        int maxCoin = 0;
        for (int i = left; i < right; i++) {
            int currCoin = getOrDefault(nums, left-1, 1) * nums[i] * getOrDefault(nums, right, 1);

            int remainingLeft = dp(nums, left, i, memo);
            int remainingRight = dp(nums, i+1, right, memo);
            maxCoin = Math.max(maxCoin, currCoin + remainingLeft + remainingRight);
        }

        memo[left][right] = maxCoin;
        return maxCoin;
    }

    private int getOrDefault(int[] nums, int pos, int defaultVal) {
        if (pos < 0 || pos >= nums.length) return defaultVal;
        return nums[pos];
    }
}
