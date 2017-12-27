package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2017/12/27.
 */
public class Problem118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans= new ArrayList<>();
        if(numRows<=0) return ans;
        List<Integer> first = new ArrayList<>() ;
        first.add(1);
        ans.add(first);
        for (int i = 1;i<numRows;i++)
        {
            List<Integer> temp = new ArrayList<>();
            List<Integer> last = ans.get(i-1);
            temp.add(1);
            for(int j=1;j<i;j++) {
                temp.add(last.get(j-1)+last.get(j));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans=generate(2);
        for(int i=0;i<ans.size();i++){
            for (int j=0;j<ans.get(i).size();j++)
                System.out.print(ans.get(i).get(j)+" ");
            System.out.println();
        }
    }
}
