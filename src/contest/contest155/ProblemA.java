package contest.contest155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Diane on 2019-09-22.
 * Goal:
 */
public class ProblemA {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int minSub = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i] - arr[i - 1];
            if (cur <= minSub) {
                if (cur < minSub) {
                    ans.clear();
                    minSub = cur;
                }
                tmp.clear();
                tmp.add(arr[i - 1]);
                tmp.add(arr[i]);
                ans.add(new ArrayList<>(tmp));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3};
        List<List<Integer>> ans = minimumAbsDifference(nums);
        for (List<Integer> tmp : ans) {
            System.out.print(Arrays.toString(tmp.toArray()) + " ");
        }
    }
}
