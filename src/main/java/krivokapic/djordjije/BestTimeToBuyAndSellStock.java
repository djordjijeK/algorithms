package krivokapic.djordjije;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                if (profit < prices[right] - prices[left]) {
                    profit = prices[right] - prices[left];
                }

                right++;
                continue;
            }

            left = right;
            right++;
        }

        return profit;
    }

}
