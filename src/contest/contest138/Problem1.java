package contest.contest138;

import java.util.Arrays;

/**
 * Created by Diane on 2019-05-26.
 * Goal:
 */
public class Problem1 {
    public int heightChecker(int[] heights) {
        int ans =0;
        int[] new_heights = new int[heights.length];
        for(int i=0;i<heights.length;i++)
            new_heights[i] = heights[i];
        Arrays.sort(new_heights);
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=new_heights[i])
                ans++;
        }
        return ans;
    }
}
