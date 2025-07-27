class Solution {
    public int maxProfit(int[] prices) {
        int cheapestPrice = 10000;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - cheapestPrice;
            if (prices[i] <= cheapestPrice) {
                cheapestPrice = prices[i];
            } 
            
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
