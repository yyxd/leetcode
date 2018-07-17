package leetcode.array;

/**
 * Created by HinTi on 2018/1/18.
 */
public class Problem11 {
    public static int maxArea(int[] height) {
        int i = 0,j=height.length-1;
        int maxArea = 0;
        while(i<j)
        {
            int temp = (j-i)*Math.min(height[j],height[i]);
            maxArea = Math.max(temp,maxArea);
            if(height[j]>height[i])
                i++;
            else
                j--;
        }
        return maxArea;
    }
}
