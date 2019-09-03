package union_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
public class Problem128 {

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            numMap.put(nums[i], nums[i]);
        Set<Integer> keySet = numMap.keySet();
        HashSet<Integer> visited = new HashSet<>();
        for (int key : keySet) {
            if (!visited.contains(key)) {
                visited.add(key);
                int v = numMap.get(key) + 1;
                while (keySet.contains(v)) {
                    if (visited.contains(v)) {
                        numMap.put(key, numMap.get(v));
                        break;
                    } else {
                        visited.add(v);
                        numMap.put(key, v);
                        v++;
                    }
                }

            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            ans = Math.max(ans, v - k + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 3, 1, 2};
        System.out.println(longestConsecutive(nums));
    }
}
