package leetcode.cn.interview_problem.stack_problem;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Diane on 2019-06-15.
 * Goal: 使用java优先队列实现获取数据流中的中位数
 *
 */
public class MedianFinderUseAPI {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });// 大顶堆存放小的一半数据
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;
    public void addNum(int num) {
        if(size%2==0){
            if(maxHeap.size()==0) maxHeap.add(num);
            else{
                int right = minHeap.peek();
                if(num<=right) maxHeap.add(num);
                else {
                    maxHeap.add(right);
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }else{
            int left = maxHeap.peek();
            if(num>=left) minHeap.add(num);
            else{
                minHeap.add(left);
                maxHeap.poll();
                maxHeap.add(num);
            }
        }
        size++;
    }

    public double findMedian() {
        if(size%2==0)
            return (maxHeap.peek()+ minHeap.peek())/2.0;
        else
            return (double)maxHeap.peek();
    }
}
