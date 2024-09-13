package top150;

import static java.lang.Math.max;

// 122. Best Time to Buy and Sell Stock II
public class BestTimeToBuyAndSell2 {
    public int maxProfit(int[] prices) {

        int prevBuy = 0, prevEmpty = 0;
        for (int i = 1; i < prices.length; i++) {
            int buy, empty;
            if (prices[i] > prices[i-1]) {
                //                dp[i][0] = max(dp[i-1][1] + prices[i] - prices[i-1], dp[i-1][0]);
                //                dp[i][1] = dp[i-1][1] + prices[i] - prices[i-1];

                empty = max(prevBuy + prices[i] - prices[i-1], prevEmpty);
                buy = prevBuy + prices[i] - prices[i-1];
            }
            else {
                //                dp[i][1] = dp[i-1][0];
                //                dp[i][0] = dp[i-1][0];
                buy= prevEmpty;
                empty = prevEmpty;
            }
            prevEmpty = empty;
            prevBuy = buy;
        }
        return max(prevBuy, prevEmpty);
    }
}

//