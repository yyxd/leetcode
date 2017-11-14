import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2017/11/10.
 */
public class Problem448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=1;i<=nums.length;i++)
            ans.add(i);
        for (int i : nums){
            if(ans.contains(i))
                ans.remove((Integer)i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums = {4,3,2,7,2,3,1,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
