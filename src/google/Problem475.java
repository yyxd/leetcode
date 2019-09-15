package google;

import java.util.Arrays;

/**
 * Created by HinTi on 2019/9/13.
 * Goal: 供暖器，贪心算法
 */
public class Problem475 {
    public int findRadius(int[] houses, int[] heaters) {
        // 贪心 ，对heaters 排序，找到距离每个house 最近的heater是什么
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0; i < houses.length; i++) {
            int cur = houses[i];
            ans = Math.max(ans, findMinDis(cur, heaters));
        }
        return ans;
    }

    public int findMinDis(int target, int[] heaters) {
        int l = 0, r = heaters.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (heaters[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        // 找到第一个>=target的数
        int ans = Math.abs(heaters[l] - target);
        return l == 0 ? ans : Math.min(ans, Math.abs(target - heaters[l - 1]));
    }
}