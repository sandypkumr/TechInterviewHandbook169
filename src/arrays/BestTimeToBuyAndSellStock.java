package arrays;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - curMin);
            curMin = Math.min(curMin, prices[i]);
        }
        return maxProfit;
    }
}
