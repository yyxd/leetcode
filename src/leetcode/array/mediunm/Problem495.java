package leetcode.array.mediunm;

/**
 * Created by Diane on 2018/3/28.
 * Teemo Attacking
 */
public class Problem495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        for (int i = 0;i<timeSeries.length-1;i++)
        {
            if(timeSeries[i]+duration>timeSeries[i+1])
            {
                ans+=(timeSeries[i+1]-timeSeries[i]);
            }
            else
                ans+=duration;
        }
        if(timeSeries.length!=0)
            ans+=duration;
        return ans;
    }

    public static void main(String[] args) {
        int []timeSeries = {1,2};
        int duration = 2;
        System.out.println(findPoisonedDuration(timeSeries,duration));
    }
}
