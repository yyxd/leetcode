package greedy.stocks;

/**
 * Created by HinTi on 2019/8/29.
 * Goal: 买卖股票的最佳时机
 */
public class StockI {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int j = prices.length-1;j>=1;j--){
            prices[j]=prices[j]-prices[j-1];
        }
        int pre = 0;
        for(int i=1;i<prices.length;i++){
            int sum = Math.max(pre+prices[i],prices[i]);
            profit = Math.max(profit,sum);
            pre = sum;
        }
        return profit;
    }
}