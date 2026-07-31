class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];
        Arrays.fill(dp, 0);

        int i = 0;
        for (int day = 1; day <= dp.length-1; day++) {
            if (day < days[i]) {
                dp[day] = dp[day-1];
                continue;
            }


            int minCost = Integer.MAX_VALUE;
            int[] dayPasses = new int[]{1, 7, 30};
            for (int j = 0; j < 3; j++) {
                int prevCost = 0;
                if (day-dayPasses[j] > 0) prevCost = dp[day-dayPasses[j]];
                minCost = Math.min(minCost, costs[j] + prevCost);
            }
            dp[day] = minCost;

            i++;

        }


        return dp[dp.length-1];
    }
}
