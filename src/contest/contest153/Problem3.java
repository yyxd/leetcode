package contest.contest153;

/**
 * Created by Diane on 2019-09-08.
 * Goal:
 */
public class Problem3 {
    public static int maximumSum(int[] arr) {
        // 如果都是负数，只能选择一个最小的负数
        int ans = 0;
        int maxElement = arr[0];//用以记录最大的数，如果是负数，则返回这个数
        // 对于每一个元素选择删或不删
//        int[][]dp = new int[arr.length][2];
        int pre = arr[0];
        int pred = 0;
        ans = Math.max(pre, pred);
        for (int i = 1; i < arr.length; i++) {
            pred = Math.max(Math.max(0, pre), pred + arr[i]);
            pre = Math.max(arr[i], pre + arr[i]);
            ans = Math.max(ans, Math.max(pre, pred));
            maxElement = Math.max(arr[i], maxElement);
        }
        return maxElement < 0 ? maxElement : ans;
    }

    public static void main(String[] args) {

    }
}
