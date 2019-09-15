package google.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by HinTi on 2019/9/14.
 * Goal:
 */
public class LintCode_391 {
    // 划分区间，起飞+1，降落-1，降落在起飞之前
    public int countOfAirplanes(List<Interval> airplanes) {
        List<int[]> points = new ArrayList<>();
        for (Interval airplane : airplanes) {
            int[] start = new int[2];
            start[0] = airplane.start;
            start[1] = 1;
            int[] end = new int[2];
            end[0] = airplane.end;
            end[1] = -1;
            points.add(start);
            points.add(end);
        }
        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int ans = 0;
        int count = 0;
        for (int[] point : points) {
            count += point[1];
            ans = Math.max(ans, count);
        }
        return ans;
    }
}