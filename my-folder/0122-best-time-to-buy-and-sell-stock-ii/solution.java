class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int currProfit = prices[i] - buy;
            if (currProfit > 0) {
                profit += currProfit;
                buy = prices[i];
            } else if (prices[i] < buy) {
                buy = prices[i];
            }
        }

        return profit;
    }
}
