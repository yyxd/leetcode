package leetcode.cn.interview_problem;

import java.util.HashMap;

/**
 * Created by Diane on 2019-05-22.
 * Goal: 求一个数组中的众数
 */
public class MajorityNumber {
    /**
     * 1. 利用hashmap 做桶排序
     * 2. 利用快排
     * 排序算法可以是因为位于n/2的数一定是众数,其实可以利用快排，只需要在一次partition中pivot的index为n/2即可
     * 3.利用摩尔定律，可以记录当前数字出现的次数，很巧妙，看代码吧
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> bucket = new HashMap<>();
        for(int num: nums){
            if(!bucket.containsKey(num))
                bucket.put(num,1);
            else{
                int times = bucket.get(num)+1;
                if(times>(nums.length/2))
                    return num;
                bucket.put(num,times);
            }
        }
        return 0;
    }

    /**
     * 最快的方法，3ms
     * @param nums
     * @return
     */
    public int majorityElementUseMol(int[] nums) {
        int count = 0;//计算当前的数字出现的次数
        int mj = 0;//当前判断的元素
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {//当次数为0时，则换下一判断元素
                mj = nums[i];
                count = 1;
            } else if (nums[i] == mj) {
                count++;//当前元素等于判断元素，次数加一
            } else {
                count--;//不等于则次数减一
            }
        }
        return mj;
    }

    /**
     * 最慢的方法，测试为520ms
     * @param nums
     * @return
     */
    public static int majorityElementUseQuickSort(int[] nums){
        if(nums.length==1) return nums[0];
        int mnIndex = nums.length/2;
//        int t = partition(nums,0,nums.length-1);
        int low = 0,high =nums.length-1;
        while (low<high){
            int t = partition(nums,low,high);
            if(t==mnIndex)
                return nums[t];
            if(t<mnIndex)
                low = t+1;
            else
                high = t-1;
        }
        return nums[mnIndex];
    }

    public static int partition(int[] nums, int start,int end){
        if(start>=end) return start;
        int pivot = nums[end];
        int s = start,e = end-1;
        while(s<e) {
            if (nums[s] > pivot) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                e--;
            }else {
                s++;
            }
        }
        // 此时s = e ,可能处于一个小于pivot的数，或者处于一个大于pivot的数,大于pivot的话直接与最后一个元素，即pivot交换
        // 将数组的最后一个元素与寻找到的位置进行交换
        System.out.println("e = "+e);
       if(nums[e]<pivot)
           e++;
       nums[end] = nums[e];
       nums[e] = pivot;
        for(int n:nums){
            System.out.print(n+"\t");
        }
        System.out.println();
       return e;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,3};
        System.out.println(majorityElementUseQuickSort(nums));
        for(int n:nums){
            System.out.print(n+"\t");
        }
    }
}
