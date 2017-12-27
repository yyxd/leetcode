package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Diane on 2017/11/21.
 */
public class Problem217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> ans = new HashSet<>(nums.length);
        for (int n :nums)
            if (ans.contains(n)) return true;
            else ans.add(n);
        return false;
    }

    public static void main(String[] args) {

    }

}
