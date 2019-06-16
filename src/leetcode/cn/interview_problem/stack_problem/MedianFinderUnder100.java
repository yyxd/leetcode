package leetcode.cn.interview_problem.stack_problem;

import java.util.HashMap;

/**
 * Created by Diane on 2019-06-15.
 * Goal:
 */
public class MedianFinderUnder100 {
    HashMap<Integer, Integer> showTimes = new HashMap<>();
    int size =0;

    public void addNum(int num) {
        showTimes.put(num,showTimes.getOrDefault(num,0)+1);
        size++;
    }

    public double findMedian() {
        if(size%2==0){
            int left = size/2-1;
            int right = size/2;
            int times = 0;
            for(int i =0;i<=100;i++){

            }
        }else
        {

        }
        return 0;
    }

}
