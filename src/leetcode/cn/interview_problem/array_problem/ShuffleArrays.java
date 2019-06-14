package leetcode.cn.interview_problem.array_problem;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Diane on 2019-06-06.
 * Goal: 打乱数组
 */
public class ShuffleArrays {
    int[] origin;

    public ShuffleArrays(int[] nums) {
        origin = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array.
     * 每次从数组中随机取出一个数来，放到数组末端。
     * 还未重排的数为k个，每次在0-k-1中选出一个数r，将A[k]与A[r]进行交换，k--
     * @return shuffle 后的数组
     */
    public int[] shuffle() {
        int n = origin.length;
        int[] shuffleArray;
        shuffleArray = Arrays.copyOf(origin, origin.length);
        int left = n;
        Random random = new Random();
        while (left > 0) {
            int i = random.nextInt(left);
            int temp = shuffleArray[left-1];
            shuffleArray[left-1] = shuffleArray[i];
            shuffleArray[i] = temp;
            left--;
        }
        return shuffleArray;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        ShuffleArrays sfa = new ShuffleArrays(nums);
        int[] ans = sfa.shuffle();
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+"\t");
        }
        ans = sfa.reset();
        System.out.println();
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+"\t");
        }
    }
}
