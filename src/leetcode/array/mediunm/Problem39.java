package leetcode.array.mediunm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HinTi on 2018/8/24.
 * Combination Sum
 */
public class Problem39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    public static boolean backtrack(List<List<Integer>> result,List<Integer> ex,int[] candidates,int remain,int startPoint){
        if(remain < 0)
        return false;
        else if(remain == 0)
        {
            List<Integer> ans = new ArrayList<>(ex);
            result.add(ans);
            return false;
        }
        else{
            for(int j = startPoint;j<candidates.length;j++){
                boolean flag;
                ex.add(candidates[j]);
                flag = backtrack(result,ex,candidates, remain-candidates[j],j);
                ex.remove(ex.size()-1);
                if(!flag) break;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int []candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates,target);
        for(List<Integer> list :res)
        {
            for (int i:list)
                System.out.print(i+"    ");
            System.out.println();
        }

    }
}
