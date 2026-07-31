class Solution {
    public int minimumBuckets(String hamsters) {
        int[] dp = new int[hamsters.length()];
        Arrays.fill(dp, -1);
        int minCost = solve(hamsters.toCharArray(), dp, 0);
        return minCost >= 100000 ? -1 : minCost;
    }

    private int solve(char[] hamsters, int[] dp, int currIndex) {
        if (currIndex >= hamsters.length) return 0;

        if (dp[currIndex] > -1) return dp[currIndex];

        if (hamsters[currIndex] != 'H') {
            return solve(hamsters, dp, currIndex+1);
        }

        int minCost = 100002;
        if (currIndex > 0 && hamsters[currIndex-1] != 'H') {
            int leftCost = 1 + solve(hamsters, dp, currIndex+1);
            minCost = Math.min(minCost, leftCost);
        }
        if (currIndex < hamsters.length-1 && hamsters[currIndex+1] != 'H') {
            int rightCost = 1 + solve(hamsters, dp, currIndex+3);
            minCost = Math.min(minCost, rightCost);
        }

        dp[currIndex] = minCost;
        return dp[currIndex];
    }
}
