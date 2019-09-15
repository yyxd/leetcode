package google.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by HinTi on 2019/9/14.
 * Goal:
 */
public class LintCode_919 {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Node> nodes = new ArrayList<>();
        for (Interval interval : intervals) {
            nodes.add(new Node(interval.start, true));
            nodes.add(new Node(interval.end, false));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.time == o2.time) {
                    if (o1.isStart) return 1;
                    else return -1;
                } else
                    return o1.time - o2.time;
            }
        });
        int ans = 0;
        int count = 0;
        for (Node node : nodes) {
            if (node.isStart) {
                ++count;
                ans = Math.max(count, ans);
            } else
                count--;
        }
        return ans;
    }
}