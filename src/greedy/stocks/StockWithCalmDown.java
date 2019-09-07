package greedy.stocks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2019/8/29.
 * Goal: 买卖股票时机含冷冻
 */
public class StockWithCalmDown {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int[] minus = new int[prices.length];
        minus[0] = -1;
        for (int i = 1; i < prices.length; i++) {
            minus[i] = prices[i] - prices[i - 1];
        }
        List<Integer> low = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            System.out.printf("%d ",minus[i]);
            if (minus[i] > 0) sum += minus[i];
            if (minus[i - 1] > 0 && minus[i] < 0 && (i + 1 < prices.length && minus[i + 1] > 0))
                low.add(i);
        }
        for (int i : low) {
            int min = Math.min(minus[i - 1], minus[i + 1]);
            min = Math.min(min, -minus[i]);
            if(min==minus[i+1])
                minus[i+1]=0;
            sum -= min;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[]prices = {8,6,4,3,3,2,3,5,8,3,8,2,6};
        int ans =maxProfit(prices);
        System.out.println();
        System.out.println(ans);
    }
}