package leetcode.cn.interview_problem.stack_problem;

/**
 * Created by Diane on 2019-06-15.
 * Goal:
 */
public class TestMain {
    public static void main(String[] args) {
        MedianFinderUseAPI mf = new MedianFinderUseAPI();
        int []nums = {78,14,50,20,13,9,25,8,13};
        for (int i = 0; i < nums.length; i++) {
            mf.addNum(nums[i]);
            System.out.println(mf.findMedian());
//            System.out.println(mf);
        }
    }
}
