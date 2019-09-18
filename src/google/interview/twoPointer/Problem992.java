package google.interview.twoPointer;

import java.util.HashMap;

/**
 * Created by HinTi on 2019/9/15.
 * Goal:
 */
public class Problem992 {
    public static int subarraysWithKDistinct(int[] A, int K) {
        // 出现的次数
        HashMap<Integer, Integer> times = new HashMap<>();
        int left = 0, pre = -1;
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            times.put(A[i], times.getOrDefault(A[i], 0) + 1);
            if (times.size() >= K) {
                while (times.size() > K) {
                    int front = A[left];
                    if (times.get(front) == 1)
                        times.remove(front);
                    else
                        times.put(front, times.get(front) - 1);
                    left++;
                    pre = left - 1;
                }
                while (times.size() == K) {
                    int front = A[left];
                    if (times.get(front) == 1)
                        break;
                    else
                        times.put(front, times.get(front) - 1);
                    left++;
                }
                ans = ans + (left - pre);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 1, 1, 2};
        System.out.println(subarraysWithKDistinct(A, 1));
    }
}