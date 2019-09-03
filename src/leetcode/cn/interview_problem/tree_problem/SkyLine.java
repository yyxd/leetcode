package leetcode.cn.interview_problem.tree_problem;

import java.util.*;

/**
 * Created by Diane on 2019-08-26.
 * Goal: 城市的天际线
 */

class Point implements Comparable<Point> {
    boolean state;//true 为进入一个矩形，false 为离开一个矩形
    int height;
    int index;

    @Override
    public int compareTo(Point o) {
        if(this.index - o.index!=0)
            return this.index-o.index;
        else if(this.state==o.state)
            if(this.state)
                return -(this.height-o.height);// 进入矩阵，先进入高度较高的
            else
                return this.height-o.height;// 离开矩阵，先离开高度较低的
        else if(!this.state&&o.state)
            return 1;
        else return -1;
    }

    public Point(boolean state, int height, int index) {
        this.state = state;
        this.height = height;
        this.index = index;
    }
}

public class SkyLine {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        int size = buildings.length;
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            points.add(new Point(true, buildings[i][2], buildings[i][0]));
            points.add(new Point(false, buildings[i][2], buildings[i][1]));
        }
        Collections.sort(points);
        for (Point point:points)
            System.out.println(point.index+" "+point.state+" "+point.height);
        // 最大堆
        PriorityQueue<Integer> heights = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });

        List<List<Integer>> result = new ArrayList<>();
        for (Point point : points) {
            int curHeight = 0;
            if (heights.peek() != null)
                curHeight = heights.peek();
            if (point.state) {// 进入矩阵
                heights.offer(point.height);
                //当进入矩阵的高度高于现有的最高的矩阵，则认为是一个拐点，加入到结果中
                if (point.height > curHeight) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(point.index);
                    ans.add(point.height);
                    result.add(ans);
                }
            } else { // 离开矩阵
                heights.remove(point.height);// 删除当前高度
                curHeight = 0;
                if (heights.peek() != null)
                    curHeight = heights.peek();
                if (curHeight < point.height) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(point.index);
                    ans.add(curHeight);
                    result.add(ans);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] bulidings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildings2 = {{2,9,10},{3,7,15},{9,12,12},{5,7,8},{3,9,19},{15,20,10},{19,24,8}};
        List<List<Integer>> res = getSkyline(buildings2);
        for (List<Integer> ans : res) {
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}
