package google.next.week4;

/**
 * Created by HinTi on 2019/7/23.
 * Goal:
 */
public class JumpGameII_Greedy {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                // 遇到边界，就更新边界，并且步数加1
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public int jumpGreedy(int[] nums) {
        int end = 0;
        int steps = 0;
        while (end < nums.length - 1) {
            int far = end + nums[end];
            if (far >= nums.length - 1) return ++steps;
            int next = 0;
            for (int i = end + 1; i <= far; i++) {
                if (i + nums[i] > next) {
                    end = i;
                    next = i+nums[i];
                }
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGameII_Greedy jumpGame = new JumpGameII_Greedy();
        int[] nums = {7, 6, 5, 4, 3, 2, 1, 1, 0};
        System.out.println(jumpGame.jumpGreedy(nums));
    }
}