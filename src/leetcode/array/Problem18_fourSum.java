package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HinTi on 2018/7/17.
 */
public class Problem18_fourSum {
    public  static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        if(nums.length<4) return answer;
        Arrays.sort(nums);
        for (int i=0;i<=nums.length-4;i++)
        {
            if(i>0&&nums[i]==nums[i-1]) continue;
            for (int j = i+1;j<=nums.length-3;j++)
            {
                if(j-1!=i&&nums[j]==nums[j-1]) continue;
                int T = target-nums[i]-nums[j];
                int s = j+1, e = nums.length-1;
                while (s<e){
                    int temp = nums[s]+nums[e];
                    if(temp==T){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[s]);
                        ans.add(nums[e]);
                        answer.add(ans);
                        s++;
                        while (s<nums.length&&nums[s]==nums[s-1])
                            s++;
                        e--;
                        while (e>=0&&nums[e]==nums[e+1])
                            e--;
                    }else if(temp<T)
                    {
                        s++;
                        while (s<nums.length&&nums[s]==nums[s-1])
                            s++;
                    }else {
                        e--;
                        while (e>=0&&nums[e]==nums[e+1])
                            e--;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int []nums = {0,0,0,0,0,0};
        List<List<Integer>> result ;
        result = fourSum(nums,0);
        if (result!=null)
        {
            for (List<Integer> ans: result) {
                System.out.println(ans.get(0)+" "+ans.get(1)+" "+ans.get(2)+" "+ans.get(3));
            }
        }
    }
}
