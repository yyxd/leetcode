package contest.contest154;

/**
 * Created by HinTi on 2019/9/15.
 * Goal:
 */
public class ProblemC {
    public static int kConcatenationMaxSum(int[] arr, int k) {
        long ans = 0;
//        long mod = (long) (10e9) + 7;
        int mod = 1000000007;
        long sum = 0, maxSubSum = 0;
        int t = 664859242;
        System.out.println(t % mod);
        long pre = 0;
        int[] arrCopy;
        if (k >= 2) {
            arrCopy = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                arrCopy[i] = arr[i];
                arrCopy[i + arr.length] = arr[i];
            }
        } else {
            arrCopy = arr;
        }
        for (int i = 0; i < arrCopy.length; i++) {
            pre = Math.max(arrCopy[i], (pre + arrCopy[i]) % mod);
            maxSubSum = Math.max(pre, maxSubSum);
            pre %= mod;
            maxSubSum %= mod;
        }
        long oPre = 0, oMaxSubSum = 0;
        for (int i = 0; i < arr.length; i++) {
            oPre = Math.max(arr[i], (oPre + arr[i]) % mod);
            oMaxSubSum = Math.max(oPre, oMaxSubSum);
            oPre %= mod;
            oMaxSubSum %= mod;
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sum %= mod;
        }
        if (sum >= 0) {
            sum %= mod;
            k %= mod;
            ans = (sum * (k - 1)) % mod;
            ans = (ans + oMaxSubSum) % mod;
        }
        ans = Math.max(maxSubSum, ans);
        return (int) ans;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(kConcatenationMaxSum(arr, 3));
        int[] arr1 = {-5, -2, 0, 0, 3, 9, -2, -5, 4};
        System.out.println(kConcatenationMaxSum(arr1, 5));

        int k = 36263;
//        System.out.println(kConcatenationMaxSum(arr2, k));
    }
}