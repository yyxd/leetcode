package leetcode.array.mediunm;

import java.util.*;

/**
 * Created by HinTi on 2018/8/24.
 * Combination sum 2
 */
public class Problem40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
    backtrack(result,new ArrayList<>(),candidates,target,0);
    List<List<Integer>> res = new ArrayList<>(result);
        return res;
}

    public static boolean backtrack(Set<List<Integer>> result,List<Integer> ex,int[] candidates,int remain,int startPoint){
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
                flag = backtrack(result,ex,candidates, remain-candidates[j],j+1);
                ex.remove(ex.size()-1);
                if(!flag) break;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int []candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> res = combinationSum2(candidates,target);
        for(List<Integer> list :res)
        {
            for (int i:list)
                System.out.print(i+"    ");
            System.out.println();
        }

    }
}
