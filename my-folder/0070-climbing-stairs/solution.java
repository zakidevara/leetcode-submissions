class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int steps1 = 1;
        int steps2 = 2;

        for (int i = 3; i <= n; i++) {
            int curr = steps2 + steps1;

            steps1 = steps2;
            steps2 = curr;
        }

        return steps2;
    }
}
