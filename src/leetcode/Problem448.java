package leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * find all numbers disappeared in an Array
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


//    将当前位置换为负数
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0;i<nums.length;i++){
            nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]>0) ans.add(i+1);

        }
        return ans;
    }
//
//    置换数组元素的位置，将nums[i]换到其对应的nums[nums[i]-1]的位置上。
    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[nums[i]-1]!=nums[i]){
                temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[nums[i]-1]=temp;
                i--;
            }
        }
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]!=i+1) ans.add(i+1);

        }
        return ans;
    }



    public static void main(String[] args) {
        int []nums = {4,3,2,7,2,3,1,1};
        System.out.println(findDisappearedNumbers3(nums));
    }
}
