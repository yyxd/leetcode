package leetcode.cn.interview_problem.stack_problem;

import java.util.List;

/**
 * Created by HinTi on 2019/6/14.
 * Goal: 数组中的第K大元素
 * Solution: 可以利用堆来做，维护一个大小为k的小顶堆
 * 还有快排
 */
public class TopK {
    public static int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(k);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>heap.getTop())
                heap.insert(nums[i]);
            System.out.println(heap);
        }
        return heap.getTop();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthLargest(nums,k);
    }
}

class Heap{
    private int size;
    private int[] nums;
    public Heap(int size){
        this.size =size;
        nums = new int[size];
    }
    public void insert(int n){
        int cur =0;
        nums[0] = n;
        int change = cur;
        while (cur<size) {
            int left = cur*2+1,right = left+1;
            if (left<size&&nums[left] < nums[change]) change = left;
            if (right<size&&nums[right] < nums[change]) change = right;
            if(change==cur) break;
            int temp = nums[change];
            nums[change] = nums[cur];
            nums[cur] = temp;
            cur = change;
        }
    }
    public int getTop(){
        if(nums.length>0)
            return nums[0];
        return Integer.MIN_VALUE;
    }

    @Override
    public String toString() {
        StringBuilder ts = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            ts.append(nums[i]);
            ts.append("\t");
        }
//        ts.append("\n");
        return ts.toString();
    }
}


