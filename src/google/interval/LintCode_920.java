package google.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by HinTi on 2019/9/14.
 * Goal:
 */
class Node {
    int time;
    boolean isStart;

    public Node(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }
}

public class LintCode_920 {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        if (intervals.size() <= 0) return true;
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start < pre.end) return false;
            else
                pre = cur;
        }
        return true;
    }


    // 扫描线做法
    public boolean canAttendMeetings2(List<Interval> intervals) {
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
        int count = 0;
        for (Node node : nodes) {
            if (node.isStart) {
                if ((++count) >= 2)
                    return false;
            } else
                count--;
        }
        return true;
    }
}