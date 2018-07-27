package leetcode.array.easy;

/**
 * Created by Diane on 2017/12/28.
 * leetcode problem 122 Best Time to Buy and Sell Stock II
 */
public class Problem122 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<1) return 0;
        int maxProfit = 0;
        int min = prices[0];
        for(int i=1;i<len;i++)
        {
            if(prices[i]<min) min = prices[i];
            else {
                maxProfit+=(prices[i]-min);
                min = prices[i];
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
