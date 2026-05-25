class Solution {
    public int coinChange(int[] coins, int amount) {
        int min = dp(coins, amount, new HashMap<>());

        return min;
    }

    public int dp(int[] coins, int target, Map<Integer, Integer> memo) {
        if (target == 0) return 0;
        
        if (memo.containsKey(target)) return memo.get(target);

        int min = -1;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= target) {  
                int subproblemMin = dp(coins, target - coins[i], memo);
                if (subproblemMin == -1) continue;
                int currMin = 1 + subproblemMin;
                if (min == -1 || currMin < min) min = currMin;
            }
        }
        
        memo.put(target, min);
        return memo.get(target);

    }
}
