package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2017/12/28.
 */
public class Problem119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if(rowIndex<0) return null;
        ans.add(1);
        for(int i=1;i<=rowIndex;i++)
        {

            for(int j = i-1;j>=1;j--)
            {
                ans.set(j,ans.get(j)+ans.get(j-1));
            }
            ans.add(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 5;
        getRow(num);
    }
}
