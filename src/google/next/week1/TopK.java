package google.next.week1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by HinTi on 2019/7/12.
 * Goal: 数组中第K大的元素
 */
public class TopK {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int top = priorityQueue.peek();
            if (nums[i] > top) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.poll();
    }

    public static int findKthLargestByQuickSort(int[] nums, int k) {
        int index = 0;
        int low = 0, high = nums.length - 1;
        k = nums.length-k;
        while (low <= high) {
            index = partition(nums, low, high);
            if (index == k ) return nums[index];
            else if (index < k ) low = index + 1;
            else high = index - 1;
        }
        return nums[index];
    }

    public static int partition(int[] nums, int start, int end) {
        if (end < start) return -1;
        if (end == start) return start;
        int pivot = nums[end];
        int minPoint = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                if (minPoint < i) {
                    int temp = nums[i];
                    nums[i] = nums[minPoint];
                    nums[minPoint] = temp;
                }
                minPoint++;

            }
        }
        nums[end] = nums[minPoint];
        nums[minPoint] = pivot;
        return minPoint;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(partition(nums, 0, nums.length - 1));
        System.out.println(findKthLargestByQuickSort(nums,2));
    }
}