package krivokapic.djordjije.slidingwindow;


public class BestTimeToBuyAndSellStock {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }

            if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }

        return profit;
    }
}
