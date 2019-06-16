package leetcode.cn.interview_problem.stack_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-06-15.
 * Goal:
 */
public class MedianFinder {

    /**
     * initialize your data structure here.
     */
    private int size = 0;
    private MaxHeap maxHeap = new MaxHeap();
    private MinHeap minHeap = new MinHeap();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        // 当两个堆的元素一样多的时候，添加进大顶堆
        if (maxHeap.getSize() == minHeap.getSize()) {
            if (maxHeap.getSize() == 0) maxHeap.insert(num);
            else {
                int right = minHeap.getTop();
                if (num <= right) maxHeap.insert(num);
                else {
                    maxHeap.insert(right);
                    minHeap.replaceTop(num);
                }
            }
        } else {
            // 当两个堆中，大顶堆的元素多于小顶堆时，添加进小顶堆
            int left = maxHeap.getTop();
            if (left <= num) minHeap.insert(num);
            else {
                minHeap.insert(left);
                maxHeap.replaceTop(num);
            }
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxHeap: \n");
        sb.append(maxHeap.toString());
        sb.append("MinHeap: \n");
        sb.append(minHeap.toString());
        return sb.toString();
    }

    public double findMedian() {
        if (size % 2 == 0)
            return ((double) maxHeap.getTop() + (double) minHeap.getTop()) / 2;
        else
            return (double) maxHeap.getTop();
    }


}

class MaxHeap {
    private List<Integer> numArray;

    MaxHeap() {
        numArray = new ArrayList<>();
    }

    public int getSize() {
        return numArray.size();
    }

    public void replaceTop(int num) {
        numArray.set(0, num);
        int cur = 0, left, right;
        while (cur < numArray.size()) {
            left = cur * 2 + 1;
            right = left + 1;
            int maxIndex = cur;
            if (left < numArray.size() && numArray.get(left) > numArray.get(maxIndex)) {
                maxIndex = left;
            }
            if (right < numArray.size() && numArray.get(right) > numArray.get(maxIndex)) {
                maxIndex = right;
            }
            if (maxIndex == cur) break;
            else {
                numArray.set(cur, numArray.get(maxIndex));
                numArray.set(maxIndex, num);
                cur = maxIndex;
            }
        }

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numArray.size(); i++) {
            sb.append(numArray.get(i));
            sb.append("\t");
        }
        sb.append("\n");
        return sb.toString();
    }

    public void insert(int num) {
        numArray.add(num);
        int cur = numArray.size() - 1;
        int father, max;
        while (cur > 0) {
            father = cur % 2==0?cur/2-1:cur/2;;
            max = Math.max(numArray.get(father), numArray.get(cur));
            if (numArray.get(father) == max) {
                // 如果父节点的值等于较大的值，则退出循环
                break;
            } else {
                // 如果较大的值是当前值，则将当前节点与父节点交换
                numArray.set(cur, numArray.get(father));
                numArray.set(father, max);
                cur = father;
            }
        }
    }

    public int getTop() {
        return numArray.get(0);
    }


}

// 小顶堆，存放大的数据
class MinHeap {
    private List<Integer> numArray;

    MinHeap() {
        numArray = new ArrayList<>();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numArray.size(); i++) {
            sb.append(numArray.get(i));
            sb.append("\t");
        }
        sb.append("\n");
        return sb.toString();
    }
    public int getSize() {
        return numArray.size();
    }

    public void replaceTop(int num) {
        numArray.set(0, num);
        int cur = 0, left, right;
        while (cur < numArray.size()) {
            left = cur * 2 + 1;
            right = left+1;
            int minIndex = cur;
            if (left < numArray.size() && numArray.get(left) < numArray.get(minIndex)) {
                minIndex = left;
            }
            if (right < numArray.size() && numArray.get(right) < numArray.get(minIndex)) {
                minIndex = right;
            }
            if (minIndex == cur) break;
            else {
                numArray.set(cur, numArray.get(minIndex));
                numArray.set(minIndex, num);
                cur = minIndex;
            }
        }
    }

    public void insert(int num) {
        numArray.add(num);
        int cur = numArray.size() - 1;
        int father, min;
        while (cur > 0) {
            father = cur % 2==0?cur/2-1:cur/2;
            min = Math.min(numArray.get(father), numArray.get(cur));
            if (numArray.get(father) == min) {
                // 如果父节点的值等于较小的值，则退出循环
                break;
            } else {
                // 如果较小的值是当前值，则将当前节点与父节点交换
                numArray.set(cur, numArray.get(father));
                numArray.set(father, min);
                cur = father;
            }
        }
    }

    public int getTop() {
        return numArray.get(0);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
