package leetcode.array.easy;

/**
 * Created by Diane on 2017/12/28.
 */
public class Problem121 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        if (len < 1) return 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < min)
                min = prices[i];
            else {
                int temp = prices[i] - min;
                maxProfit = (temp > maxProfit) ? temp : maxProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int []array = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(array);
        System.out.println(profit);
    }
}
