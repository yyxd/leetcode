package greedy.stocks;

/**
 * Created by HinTi on 2019/8/29.
 * Goal:
 */
public class StockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int j = prices.length - 1; j >= 1; j--) {
            prices[j] = prices[j] - prices[j - 1];
        }
        for(int i=1;i<prices.length;i++){
            if(prices[i]>0)
                profit+=prices[i];
        }
        return profit;
    }
}