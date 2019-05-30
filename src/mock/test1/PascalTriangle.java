package mock.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2019/5/13.
 * Goal:
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows <= 0) return ans;
        List<Integer> line1 = new ArrayList<>();
        line1.add(1);
        ans.add(line1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> preLine = ans.get(i - 1);
            List<Integer> curLine = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int pre = j - 1 >= 0 ? preLine.get(j - 1) : 0;
                int next = j < i ? preLine.get(j) : 0;
                curLine.add(pre + next);
            }
            ans.add(curLine);
        }
        return ans;
    }

}
