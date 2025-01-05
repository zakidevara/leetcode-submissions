class Solution {
    public int climbStairs(int n) {
        return recursive(n, new HashMap());
    }

    private int recursive(int n, Map<Integer, Integer> dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp.get(n) != null) return dp.get(n);

        int result = recursive(n - 2, dp) + recursive(n - 1, dp);
        dp.put(n, result);
        return result;
    }
}
