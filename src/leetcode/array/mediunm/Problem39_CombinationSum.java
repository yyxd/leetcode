package leetcode.array.mediunm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HinTi on 2018/7/26.
 */
public class Problem39_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        compute(candidates,target,ans,result,0);
        return result;
    }

    public static void compute(int []candidate,int target,List<Integer> ans,List<List<Integer>> result,int start)
    {
       for (int i=start;i<candidate.length;i++)
       {
          if(target>0){
              ans.add(candidate[i]);
              compute(candidate,target-candidate[i],ans,result,i);
              ans.remove(candidate[i]);
          }
           else if(target<0)
               return;
           else
          {
              List<Integer> temp = new ArrayList<>();
             temp.addAll(ans);
              result.add(temp);
              return;
          }
       }

    }

    public static void main(String[] args) {
        int []candidates = {2,3,5};
        int target = 8;
        combinationSum(candidates,target);
    }
}
