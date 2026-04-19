class Solution {
    private static final int MOD = ((int) Math.pow(10, 9)) + 7;

    
    public int numRollsToTarget(int n, int k, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] next_dp = new int[target+1];

            for (int j = 1; j <= k; j++) {
                for (int total = j; total <= target; total++) {
                    next_dp[total] = (next_dp[total] + dp[total-j]) % MOD;
                }
            }

            dp = next_dp;
        }

        return dp[target];
    }

}
