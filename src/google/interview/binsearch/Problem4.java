package google.interview.binsearch;

/**
 * Created by HinTi on 2019/9/11.
 * Goal: 寻找两个有序数组的中位数 要求时间复杂度为O(log(m+n))
 */
public class Problem4 {
    public double findMedianSortedArray(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int mini = 0, maxi = m;
        int halfLen = (m + n + 1) / 2;
        // i = mini~maxi
        // j = (m+n+1)/2- i
        while (mini <= maxi) {
            int i = (mini + maxi) / 2;
            int j = halfLen - i;
            if (i < maxi && B[j - 1] > A[i]) {
                mini = i + 1;// i取的比较小
            } else if (i > mini && A[i - 1] > B[j]) {
                maxi = i - 1; // i取的比较大
            } else { // i 取的刚好
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;

    }
}