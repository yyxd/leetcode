package leetcode.cn.interview_problem.array_problem;

/**
 * Created by Diane on 2019-06-03.
 * Goal: 将0移动到数组的末尾，同时保证非零元素的相对顺序
 * Solution:在一次遍历中统计非零元素的数量，并将非零元素移动到数组前端
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int zeroes=0;
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) zeroes++;
            else {
                if(startIndex!=i)
                    nums[startIndex]=nums[i];
                startIndex++;
            }
        }
        for(int i=startIndex;i<nums.length;i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num+"\t");
        }
    }
}
