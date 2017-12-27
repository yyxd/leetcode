package leetcode.array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diane on 2017/9/19.
 */
public class leetcode1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans={0,0};
        for(int i=0;i<nums.length-1;i++){
            int result = target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(result==nums[j]) {
                    ans[0]=i;ans[1]=j;
                    return ans;
                }

            }
        }
        return ans;
    }

    public static int[] HashMapTwoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],i);
        for(int i = 0;i<nums.length;i++){
            int ans = target-nums[i];
            if(map.containsKey(ans)&&map.get(ans)!=i)
                return new int[]{i,map.get(ans)};
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] nums={2,3,11,6};
        int target=9;
        int[] ans = HashMapTwoSum(nums,target);
        System.out.println(ans[0]+","+ans[1]);
    }

}
