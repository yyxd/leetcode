package google.interval;

import java.util.*;

/**
 * Created by HinTi on 2019/9/14.
 * Goal: 天际线问题 skyline
 */
class Skyline implements Comparable<Skyline> {
    int index;
    int height;

    public Skyline(int index, int height) {
        this.index = index;
        this.height = height;
    }

    @Override
    public int compareTo(Skyline o) {
        if (this.index == o.index) {
            return -(this.height - o.height);
        } else
            return this.index - o.index;
    }
}

public class LintCode_131 {
    public static List<List<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        List<Skyline> skylines = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int s = buildings[i][0];
            int e = buildings[i][1];
            int h = buildings[i][2];
            skylines.add(new Skyline(s, h));
            skylines.add(new Skyline(e, -h));
        }
        Collections.sort(skylines);
        // 大顶堆
        Queue<Integer> heights = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        int pre = -1;
        for (Skyline skyline : skylines) {
            // 记录下所有的拐点的位置
            if (skyline.height > 0) {
                // 一个新区间进入
                if (heights.peek() != null) {
                    int top = heights.peek();
                    int h = skyline.height;
                    if (h > top) {
                        List<Integer> res = new ArrayList<>();
                        res.add(pre);
                        res.add(skyline.index);
                        res.add(top);
                        ans.add(res);
                        pre = skyline.index;
                    }
                } else {
                    pre = skyline.index;
                }
                heights.offer(skyline.height);
            } else {
                int h = -(skyline.height);
                heights.remove(h);
                int top = heights.peek() == null ? 0 : heights.peek();
                if (h > top) {
                    List<Integer> res = new ArrayList<>();
                    res.add(pre);
                    res.add(skyline.index);
                    res.add(h);
                    ans.add(res);
                    pre = skyline.index;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] buildings = {
                {1, 3, 3},
                {2, 4, 4},
                {5, 6, 1}
        };
        List<List<Integer>> ans = buildingOutline(buildings);
        for (List<Integer> list : ans) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}