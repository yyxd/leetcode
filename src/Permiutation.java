import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HinTi on 2019/6/30.
 * Goal: 全排列，回溯
 */
public class Permiutation {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permutation(int n) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        permutation(n, 0, ans,visited);
        return results;
    }

    public List<List<Integer> >permutation(int[] nums){
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permutation(nums,0,ans,visited);
        return results;
    }

    public void permutation(int[] nums, int start,List<Integer> ans,boolean[] visited){
        if(start==nums.length){
            results.add(new ArrayList<>(ans));
        }else {
            for(int i=0;i<nums.length;i++){
                if(!visited[i]){
                    if(i-1>=0&&nums[i]==nums[i-1]) {
                        continue;
                    }
                    else {
                        visited[i] = true;
                        ans.add(nums[i]);
                        permutation(nums,start+1,ans,visited);
                        visited[i] = false;
                        ans.remove(ans.size()-1);
                    }
                }
            }
        }
    }

    public void permutation(int n, int start, List<Integer> ans,boolean[] visited) {
        if (start == n) {
            results.add(new ArrayList<>(ans));
        } else {
            for(int i =1;i<=n;i++){
                if(!visited[i]){
                    visited[i] = true;
                    ans.add(i);
                    permutation(n,start+1,ans,visited);
                    ans.remove(ans.size()-1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Permiutation problem = new Permiutation();
        int[] nums = {1,1,2,3,4};
        List<List<Integer>> ans = problem.permutation(nums);
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> res = ans.get(i);
//            System.out.println(res.size());
            res.forEach(num-> System.out.print(num+"\t"));
            System.out.println();
        }
    }
}