package greedy.stocks;

/**
 * Created by HinTi on 2019/8/29.
 * Goal:
 */
public class StockIII {
    // 状态转移，定义4个变量
    // b1 第一次买入，s1 第一次卖出 b2 第二次买入，s2 第二次卖出
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) return 0;
        int profit = 0;
        int b1 = -prices[0];
        int s1 = Integer.MIN_VALUE;
        int b2 = Integer.MIN_VALUE;
        int s2 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            b1 = Math.max(b1, -prices[i]);// 买入价格最低的股票
            s1 = Math.max(s1, b1 + prices[i]);// 以之前的最低的价格买入股票，然后选择今天卖出
            b2 = Math.max(b2, s1 - prices[i]);// 以之前最赚钱的卖出s1,然后买入
            s2 = Math.max(s2, b2 + prices[i]);// 以之前第二次买入利润最高时，卖出
        }
        return Math.max(s2, profit);
    }

    public int maxProfitUseDP(int[] prices){
        int[][]dp = new int[prices.length][2];
        return 0;
    }
}