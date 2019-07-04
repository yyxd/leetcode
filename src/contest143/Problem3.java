package contest143;


/**
 * Created by HinTi on 2019/6/30.
 * Goal:
 */
public class Problem3 {
    public static int minHeightShelves(int[][] books, int shelf_width) {
        if (books.length <= 0) return -1;
        int[] dp = new int[books.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= books.length; i++) {
            int maxHeight = 0;
            int width = 0;
            for (int j = i; j >= 1; j--) {
                width = width + books[j - 1][0];
                if (width > shelf_width)
                    break;
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight);
            }
        }
        return dp[books.length];
    }

    public static void main(String[] args) {
        System.out.println();
    }
}