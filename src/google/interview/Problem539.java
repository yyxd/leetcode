package google.interview;

import java.util.Arrays;
import java.util.List;

/**
 * Created by HinTi on 2019/9/14.
 * Goal:
 */
public class Problem539 {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String p = timePoints.get(i);
            String[] time = p.split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            minutes[i] = h * 60 + m;
        }
        Arrays.sort(minutes);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.length; i++)
            ans = Math.min(ans, minutes[i] - minutes[i - 1]);
        ans = Math.min(ans, minutes[0] - minutes[minutes.length - 1] + (24 * 60));
        return ans;
    }
}