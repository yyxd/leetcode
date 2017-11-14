package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by hh23485 on 2017/11/7.
 */
public class Problem581 {
    // Using Sort
    public static int findUnsortedSubarray(int[] nums) {
        int [] copyNums = new int[nums.length];
        copyNums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int ans =0;
        int firstIndex=0,lastIndex =0;
        for(int i=0;i<nums.length;i++)
           if(nums[i]!=copyNums[i]){
            firstIndex = i;break;
           }

        for(int i=nums.length-1;i>=0;i--)
            if(nums[i]!=copyNums[i]){
                lastIndex = i;break;
            }
            ans = lastIndex-firstIndex+1;
        return ans==1?0:ans;
    }

    //using Stack 栈里存储的是数组中元素
    public static int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> smallNums = new Stack<Integer>();
        Stack<Integer> largeNums = new Stack<Integer>();
        int firstIndex = -1;
        boolean flag = true;
        for(int i=0;i<nums.length;i++){
            if (flag&&(i==0||nums[i]>=smallNums.peek())) {
                smallNums.push(nums[i]);
                firstIndex++;
            }else{
                flag = false;
                while (!smallNums.isEmpty()&&nums[i]<smallNums.peek()){
                    smallNums.pop();
                    firstIndex--;
                }
            }
        }
        if (firstIndex==nums.length-1)
            return 0;
        flag = true;
        int lastIndex = nums.length-1;
        for (int i=nums.length-1;i>=0;i--){
            if (flag&&(i==nums.length-1||nums[i]<=largeNums.peek())) {
                largeNums.push(nums[i]);
                lastIndex--;
            }else{
                flag = false;
                while (!largeNums.isEmpty()&&nums[i]>largeNums.peek()){
                    largeNums.pop();
                    lastIndex++;
                }
            }
        }
        return lastIndex-firstIndex;
    }
    //使用栈，栈里存储的是数组的下标
    public static int findUnsortedSubarray3(int []nums){
        Stack<Integer> stack = new Stack<Integer>();
        int l=nums.length,r=0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&(nums[stack.peek()]>nums[i]))
                l = Math.min(l,stack.pop());
            stack.push(i);
        }
        stack.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&&(nums[stack.peek()]<nums[i]))
                r = Math.max(r,stack.pop());
            stack.push(i);
        }
        return r-l>0?r-l+1:0;
    }



    public static void main(String[] args) {
        int []nums1={0,1,3,2,4,5};
        int []nums3={0,1,2,3,4,5};
        int []nums2 = {2,6,4,8,10,9,15};
        int []nums4 = {5,4,3,2,1};
        int []nums5 = {1,2,3,3,3};
//        System.out.println(findUnsortedSubarray(nums1));
        System.out.println(findUnsortedSubarray2(nums1));

//        System.out.println(findUnsortedSubarray(nums3));
        System.out.println(findUnsortedSubarray2(nums3));

//        System.out.println(findUnsortedSubarray(nums2));
        System.out.println(findUnsortedSubarray2(nums2));
        System.out.println(findUnsortedSubarray2(nums4));
        System.out.println(findUnsortedSubarray2(nums5));
    }
}
