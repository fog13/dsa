package top150;

// 121. Best Time to Buy and Sell Stock
public class BestTimeToBuyAndSell1 {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(minPrice > prices[i]) {
                minPrice = prices[i];
                continue;
            }
            if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}

