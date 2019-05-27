package acwing.leetcode4.week2;

import java.util.*;

/**
 * Created by HinTi on 2018/11/29.
 * Goal: leetcode problem 56
 */
class Interval {
    int start;
    int end;
    public Interval(){
        start =0;
        end =0;
    }
    public Interval(int s, int e){
        start = s;
        end = e;
    }
}
public class Problem56_MergeIntervals {
    private class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> ans = new LinkedList<>();
        if(intervals.size()<=0) return ans;
        Collections.sort(intervals,new IntervalComparator());
        ans.add(intervals.get(0));
        for (Interval interval:intervals) {
            Interval current = ans.peekLast();
            if (interval.start > current.end) {
                ans.add(interval);
            } else {
                if (interval.end > current.end)
                     current.end = interval.end;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Problem56_MergeIntervals problem = new Problem56_MergeIntervals();
    }
}
