package top150;

// 309. Best Time to Buy and Sell Stock with Cooldown
public class BestTimeToBuyAndSellCooldown {
    public int maxProfit(int[] prices) {
        int maxBuy = -prices[0], maxEmpty = 0, maxLastEmpty = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = maxEmpty;
            maxBuy = Math.max(maxBuy, maxLastEmpty - prices[i]);
            maxEmpty = Math.max(maxLastEmpty, Math.max(maxEmpty, maxBuy + prices[i]));
            maxLastEmpty = Math.max(maxLastEmpty, temp);
        }
        return Math.max(maxEmpty, maxLastEmpty);
    }
}
