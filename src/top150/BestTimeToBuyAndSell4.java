package top150;

// 188. Best Time to Buy and Sell Stock IV
public class BestTimeToBuyAndSell4 {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int k = 2;
        int[] bought = new int[k];
        int[] sold = new int[k];
        for (int i = 0; i < k; i++) {
            bought[i] = -prices[0];
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    bought[j] = Math.max(bought[j], -prices[i]);
                    sold[j] = Math.max(sold[j], bought[j] + prices[i]);
                    continue;
                }
                bought[j] = Math.max(bought[j], sold[j - 1] - prices[i]);
                sold[j] = Math.max(sold[j - 1], Math.max(sold[j], bought[j] + prices[i]));
            }
        }
        return sold[k - 1];
    }
}

