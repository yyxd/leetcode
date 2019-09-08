package google.next.week4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by HinTi on 2019/7/24.
 * Goal: 无重叠区间
 */
public class OverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        // 按照区间结尾的大小进行排序
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 每次选择结尾最小的，且与前一个区间不重叠
        int num = 1;
        int prevTail = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 与上一个区间重叠
            if(prevTail > intervals[i][0])
                continue;
            // 当与上一个区间不重叠时进行移位
            prevTail = intervals[i][1];
            num++;
        }
        return intervals.length - num;
    }
}