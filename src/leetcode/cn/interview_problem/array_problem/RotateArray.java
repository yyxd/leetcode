package leetcode.cn.interview_problem.array_problem;

/**
 * Created by HinTi on 2019/5/31.
 * Goal:
 * Solution: 将k取模，将k后面的字符替换到应该的位置，然后将后面的字符进行反转
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        int j=0 ;
        for(int i=nums.length-k+1;i<nums.length;i++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++;
        }
        int mid = (nums.length+j)/2;
        int p = j,q = nums.length-1;
        while (p<mid){
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
            p++;
            q--;
        }
    }
}
