package leetcode.cn.interview_problem.array_problem;

import java.util.Random;

/**
 * Created by Diane on 2019-06-06.
 * Goal:
 */
public class ShuffleArrays {
    int[] origin;
    public ShuffleArrays(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    /**
     * 重新建立一个数组p，将原始数组按照p的大小来进行排序
     * @return shuffle 后的数组
     */
    public int[] shuffle() {
        int n = origin.length;
        int[] p = new int[n];
        Random random = new Random();
        for (int i = 1;i<n;i++)
            p[i]= random.nextInt(n*n*n);

        return p;
    }
}
